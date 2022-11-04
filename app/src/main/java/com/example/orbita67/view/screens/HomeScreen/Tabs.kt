package com.example.orbita67.view.screens.HomeScreen

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orbita67.R
import com.example.orbita67.model.graphs.DetailsScreen
import com.example.orbita67.model.graphs.data.Product
import java.util.ArrayList

@Composable
fun TabScreenOne(){
    CountryNavigation()
}

@Composable
fun TabScreenTwo(){
    CountryNavigation()
}

@Composable
fun TabScreenThree(){
    CountryNavigation()
}




@Composable
fun CountryNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "CountryList"
    ) {
        composable("CountryList") {
            CountryListScreen(navController)
        }
    }
}

@Composable
fun CountryListScreen(navController: NavHostController) {
    val textVal = remember { mutableStateOf(TextFieldValue("")) }
    Column {
        CountryList(textVal)
    }
}


@Composable
fun CountryList(textVal: MutableState<TextFieldValue>) {
    val context = LocalContext.current
    val countries = getListOfCountries()
    var filteredCountries: ArrayList<Array<String>>
    LazyColumn(
        modifier = Modifier.fillMaxWidth().height(400.dp)
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
            CountryListItem(
                countryText = filteredCountries,
                onItemClick = { selectedCountry ->
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
            painter = painterResource(id = R.drawable.ic_email),
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

        }
    }
}

@Composable
fun getListOfCountries(): ArrayList<Array<String>> {
    var Fam = "Zanin"
    var Name = "Pavel"
    var nickname = "default"

    val Array = ArrayList<Array<String>>()
    for (i in 1..1000) {
        Array.add(arrayOf("Alexandr Shultsev", "@id55324", "1111"))
        Array.add(arrayOf("Pavel Zanin", "@id55324", "421"))
        Array.add(arrayOf("Nikolai Andreev", "@id55324", "5"))
        Array.add(arrayOf("Andrey Nikolaev", "@id45324", "121"))
    }

    val countryListWithEmojis = ArrayList<Array<String>>()
    for (j in 0 until Array.size) {
        countryListWithEmojis.add(arrayOf(Array[j][0], Array[j][1], j.toString(), Array[j][2]))
    }
    return countryListWithEmojis
}



