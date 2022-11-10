package com.example.orbita67.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orbita67.R
import com.example.orbita67.ui.theme.PrimaryColor
import com.example.orbita67.ui.theme.Shapes
import com.example.orbita67.ui.theme.cera_round_pro_regular
import com.example.orbita67.view.screens.CircularButton

@Composable
fun CardItem(
    countryText: Array<String>,
    onItemClick: (Array<String>) -> Unit,
//    title: String = "",
//    price: String = "",
//    imagePainter: Painter
) {
    Box(

    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .width(160.dp)
                .clickable { onItemClick(countryText) },
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cup), contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .background(PrimaryColor)
                        .aspectRatio(1f)
                        .padding(20.dp),
                    contentScale = ContentScale.Fit
                )
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .height(50.dp)
                ) {
                    Text(text = countryText[0],
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = cera_round_pro_regular
                    )
                    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                        Row(modifier = Modifier.fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                fontFamily = cera_round_pro_regular,
                                text = "${countryText[3]} ₽",
                                textAlign = TextAlign.Center,
                            )
                        }

                        ServingCalculator()
                    }
                }
            }
        }
    }

}


@Composable
fun ServingCalculator() {
    var value by remember { mutableStateOf(0) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(Shapes.medium)
    ) {
        //Text(text = "Serving", Modifier.weight(1f), fontWeight = Medium)

        if(value>0){
            CircularButton(iconResouce = R.drawable.ic_minus, elevation = null, color = PrimaryColor) { value-- }
            //Text(text = "$value", Modifier.padding(16.dp), fontWeight = Medium)
            Text(text = "$value")
        }
        CircularButton(iconResouce = R.drawable.ic_plus, elevation = null, color = PrimaryColor) { value++ }
    }
}

@Composable
@Preview
fun prr(){
//    CardItem(
//        imagePainter = painterResource(id = R.drawable.cup),
//        title = "Капучино",
//        price = "199",
//    )
}