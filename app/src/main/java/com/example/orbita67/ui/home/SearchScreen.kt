package com.example.orbita67.ui.home

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.orbita67.MainActivity
import com.example.orbita67.R
import com.example.orbita67.model.graphs.DetailsScreen
import com.example.orbita67.ui.components.CardItem
import com.example.orbita67.ui.home.ProductDetail.ProductDetail
import com.example.orbita67.ui.theme.BottomBoxShape
import com.example.orbita67.ui.theme.PrimaryColor
import com.example.orbita67.ui.theme.cera_round_pro_regular


@Composable
fun SearchScreenContent(onClick: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "CountryList"
    ) {
        composable("CountryList") {
            val textVal = remember { mutableStateOf(TextFieldValue("")) }
            Column() {
                SearchTopBar(textVal)
                CountryList(textVal, onClick = { onClick() })
            }
        }
    }
}









@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CountryList(textVal: MutableState<TextFieldValue>, onClick: () -> Unit) {
    val context = LocalContext.current
    val countries = MainActivity().getListOfCountries()
    var filteredCountries: ArrayList<Array<String>>
    val navController = rememberNavController()


    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 150.dp),
    ) {
        val searchText = textVal.value.text
        filteredCountries = if (searchText.isEmpty()) {
            countries
        } else {
            val resultList = ArrayList<Array<String>>()
            for (country in countries) {
                if ((country[0] + country[1]).lowercase().contains(searchText.lowercase())) {
                    resultList.add(country)
                }
            }
            resultList
        }

        items(filteredCountries) { filteredCountries: Array<String> ->
            CardItem(
                countryText = filteredCountries,
                onItemClick = { selectedCountry ->
                    onClick()
                    Toast.makeText(context, selectedCountry[0], Toast.LENGTH_SHORT).show()


                }
            )
        }
    }
}


@Composable
fun CountryListItem(
    countryText: Array<String>,
    onItemClick: (Array<String>) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(countryText) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = countryText[2],
            modifier = Modifier
                .padding(10.dp)
                .width(40.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(
                text = countryText[0],
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
            Text(
                text = countryText[1],
                color = Color.Gray,
                letterSpacing = 1.sp
            )
            CountCrown(count = countryText[3], R.drawable.ic_notifications)
        }
    }
}




@Composable
fun SearchTopBar(textVal: MutableState<TextFieldValue>) {
    TextField(
        value = textVal.value,
        onValueChange = { textVal.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp),
        leadingIcon = {
            Row(
                modifier = Modifier.padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search), contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(10.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .height(20.dp)
                        .background(PrimaryColor)
                )
            }
        },
        label = {
            Text(
                text = "Найди свой кофе",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = cera_round_pro_regular)
        },
        trailingIcon = {
            if (textVal.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        textVal.value = TextFieldValue("")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            } else {
                null

            }
        },
        singleLine = true,
        shape = BottomBoxShape.medium,
        keyboardOptions = KeyboardOptions(
            keyboardType =
            KeyboardType.Text,
            imeAction = ImeAction.Done
        ),

        textStyle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = cera_round_pro_regular
        ),

        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            backgroundColor = Color(0xFF68686A),
            cursorColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White
        )
    )
}




@Composable
fun CountCrown(count: String, icon: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = count,
            color = Color(0xFFEBB52C),
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            fontFamily = cera_round_pro_regular)
        Image(painter = painterResource(id = icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(5.dp, 0.dp)
                .size(10.dp)
        )
    }
}

