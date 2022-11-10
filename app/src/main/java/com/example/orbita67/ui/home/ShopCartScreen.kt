package com.example.orbita67.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orbita67.R
import com.example.orbita67.ui.theme.cera_round_pro_regular

@Composable
fun CartContent(){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Icon(
            painter = painterResource(id = R.drawable.ic_shopping_bag), contentDescription = "",
            tint = Color.Gray,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Корзина пуста",
            fontFamily = cera_round_pro_regular,
            color = Color.Gray,
            fontSize = 35.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
@Preview
fun previewFav(){
    CartContent()
}