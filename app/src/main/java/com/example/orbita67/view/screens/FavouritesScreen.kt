package com.example.orbita67.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun FavouritesContent(onClick: () -> Unit){
    Text(
        text = "FavouritesContent",
        modifier = Modifier.fillMaxSize().clickable { onClick() }, textAlign = TextAlign.Center
    )
}