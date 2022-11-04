package com.example.orbita67.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.orbita67.R

val cera_round_pro_black = FontFamily(Font(R.font.cera_round_pro_black))
val cera_round_pro_bold = FontFamily(Font(R.font.cera_round_pro_bold))
val cera_round_pro_medium = FontFamily(Font(R.font.cera_round_pro_medium))
val cera_round_pro_regular = FontFamily(Font(R.font.cera_round_pro_regular))
val cera_round_pro_light = FontFamily(Font(R.font.cera_round_pro_light))
val cera_round_pro_thin = FontFamily(Font(R.font.cera_round_pro_thin))

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)