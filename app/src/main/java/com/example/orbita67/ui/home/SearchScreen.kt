package com.example.orbita67.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orbita67.MainActivity
import com.example.orbita67.R
import com.example.orbita67.ui.components.CardItem
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
    val products = MainActivity().getListOfProducts()
    var filteredProducts: ArrayList<Array<String>>
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 150.dp),
    ) {
        val searchText = textVal.value.text
        filteredProducts = if (searchText.isEmpty()) {
            products
        } else {
            val resultList = ArrayList<Array<String>>()
            for (product in products) {
                if ((product[0] + product[1]).lowercase().contains(searchText.lowercase())) {
                    resultList.add(product)
                }
            }
            resultList
        }
        items(filteredProducts) { filteredCountries: Array<String> ->
            CardItem(
                countryText = filteredCountries,
                onItemClick = { selectedCountry ->
                    onClick()
                }
            )
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






