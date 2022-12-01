package com.example.orbita67.ui.authorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.orbita67.MainViewModel
import com.example.orbita67.model.graphs.DetailsScreen

@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {
    val currentItem = viewModel.allMovies.observeAsState(listOf()).value.firstOrNull() {it.id == itemId.toInt()}

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp)
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = rememberImagePainter(currentItem?.image?.medium), contentDescription = null,
            modifier = Modifier.size(512.dp))
            Text(text = currentItem?.name ?: "",
            fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

        }
    }
}