package com.example.orbita67.ui.components

import android.util.Size
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object _Button {
    @Composable
    fun MainButton(function: () -> Unit, text: String, width: Int = 340) {

        Button(
            onClick = {
                function()
            },
            modifier = Modifier
                .width(width.dp)
                .height(56.dp)
                .clickable {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFBC370),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50.dp)
        ){
            Text(text, fontSize = 16.sp, textAlign = TextAlign.Center)
        }
    }

    @Composable
    fun OutlinedButton(function: () -> Unit, text: String, width: Int = 340) {
        Button(
            onClick = {
                function()
            },
            border = BorderStroke(2.dp, Color(0xFFFBC370)),
            modifier = Modifier
                .width(width.dp)
                .height(56.dp)
                .clickable {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color(0xFFFBC370)
            ),
            shape = RoundedCornerShape(50.dp)
        ){
            Text(text, fontSize = 16.sp)
        }
    }
}

