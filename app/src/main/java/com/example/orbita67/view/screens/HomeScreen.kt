package com.example.orbita67.view.screens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.FilterQuality.Companion.Medium
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.orbita67.R
import com.example.orbita67.model.graphs.data.Product
import com.example.orbita67.ui.theme.*
import com.example.orbita67.view.screens.HomeScreen.CountryNavigation
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch
import java.util.ArrayList


@Composable
fun HomeContent(onClick: () -> Unit){
    HomeScreenContent()
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreenContent()
}

@Composable
fun HomeScreenContent() {
    Box(Modifier.verticalScroll(rememberScrollState())) {
        Column() {

            Content()
        }
    }
}

@Composable
fun SearchBar() {
    TextField(
        maxLines = 1,
        value = "", onValueChange = {
            ""
        },

        label = {
            Text(
                text = "Найди свой кофе",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = cera_round_pro_regular)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            backgroundColor = Color(0xFF68686A),
            cursorColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White
        ),
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
        keyboardOptions = KeyboardOptions(
            keyboardType =
            KeyboardType.Phone,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        shape = BottomBoxShape.medium,
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = cera_round_pro_regular
        )
    )



}







@OptIn(ExperimentalPagerApi::class)
@Composable
fun Content() {
    Spacer(modifier = Modifier.height(16.dp))
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp, bottom = 20.dp),
            fontSize = 28.sp,
            text = "Выбери свой любимый кофейный напиток!",
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            fontFamily = cera_round_pro_regular,
            color = Color.Black
        )
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        Promotions()
        Spacer(modifier = Modifier.height(16.dp))
        TabScreen()
        Spacer(modifier = Modifier.height(16.dp))
        BestSellerSection()

    }
}

@Composable
fun ServingCalculator() {
    var value by remember { mutableStateOf(0) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(Shapes.medium)
            .padding(horizontal = 16.dp)
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
fun CircularButton(
    @DrawableRes iconResouce: Int,
    color: Color = Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = White, contentColor = color),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painterResource(id = iconResouce), null)
    }
}




@Composable
fun Promotions() {
    LazyRow(
        Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "Fruit",
                subtitle = "Start @",
                header = "$1",
                backgroundColor = Color(0xFF2B3046)
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
                backgroundColor = Color(0xFFE17546)
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
                backgroundColor = Color(0xFFFBC370)
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
                backgroundColor = Color(0xFF135D6E)
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ) {
        Row {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(text = subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Composable
fun BestSellerSection() {
    Column() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Популярные", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }

        BestSellerItems()
    }
}

@Composable
fun BestSellerItems() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "Iceberg Lettuce",
                price = "1.99",
                discountPercent = 10
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "Apple",
                price = "2.64",
                discountPercent = 5
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "Meat",
                price = "4.76",
                discountPercent = 20
            )
        }
    }
}

@Composable
fun BestSellerItem(
    title: String = "",
    price: String = "",
    discountPercent: Int = 0,
    imagePainter: Painter
) {
    Card(
        Modifier
            .width(160.dp)
    ) {
        Column(
            Modifier
                .padding(bottom = 32.dp)
        ) {
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Row {
                    Text(
                        "$${price}",
                        textDecoration = if (discountPercent > 0)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                        color = if (discountPercent > 0) Color.Gray else Color.Black
                    )
                    if (discountPercent > 0) {
                        Text(text = "[$discountPercent%]", color = MaterialTheme.colors.primary)
                    }
                    ServingCalculator()
                }
            }
        }
    }
}




