package com.example.orbita67.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.orbita67.MainViewModel
import com.example.orbita67.data.models.Movies

@Composable
fun MoviesScreen(navController:NavController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach{ Log.i("checkData", "id: ${it.id} name: ${it.name}")}
    Surface(Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.padding(20.dp)){
            items(allMovies.take(10)){item ->
                MoviesItem(item = item, navController = navController)
            }
        }
    }
}

@Composable
fun MoviesItem(item: Movies, navController: NavController) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.clickable {
            navController.navigate("DETAILS" + "/${item.id}")
        }
    )
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)){
            Image(painter = rememberImagePainter(item.image.medium), contentDescription = null, modifier = Modifier.size(128.dp))
            Column {
                Text( text = item.name)
            }
            Row(){
                Text(text = "Rating")
                Text(text = item.rating.average.toString())
            }

            Row(){
                Text(text = "Genre")
                item.genres.take(2).forEach{ Text( text = " $it ")}
            }
            Row{
                Text(text = "Premiered")
                Text(text = item.premiered)
            }
        }

    }
}