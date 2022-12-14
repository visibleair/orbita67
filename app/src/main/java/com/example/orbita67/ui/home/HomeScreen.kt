package com.example.orbita67.view.screens

import TabItem
import androidx.annotation.DrawableRes
import androidx.compose.animation.Animatable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orbita67.MainActivity
import com.example.orbita67.R
import com.example.orbita67.ui.components.CardItem
import com.example.orbita67.ui.theme.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@Composable
fun HomeContent(onClick: () -> Unit, onSearchBarClick: () -> Unit){
    Box(modifier = Modifier
        .fillMaxSize())
    {
        HomeScreenContent(onClick = { onClick() }, onSearchBarClick = {onSearchBarClick()})
    }

}






@Composable
fun HomeScreenContent(onClick: () -> Unit, onSearchBarClick: () -> Unit) {
    Box(Modifier.verticalScroll(rememberScrollState())) {
        Column() {

            Content(onClick = { onClick()}, onSearchBarClick = { onSearchBarClick()})
        }
    }
}

@Composable
fun SearchBar(onSearchBarClick: () -> Unit) {
    val tabs = listOf(
        TabItem.Music,
        TabItem.Movies,
        TabItem.Books
    )
    TextField(
        maxLines = 1,
        value = "", onValueChange = {
            ""
        },

        label = {
            Text(
                text = "?????????? ???????? ????????",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = cera_round_pro_regular)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
            .onFocusChanged { event ->
                if (event.isFocused) {
                    onSearchBarClick()
                }
            },
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
            KeyboardType.Text,
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
fun Content(onClick: () -> Unit, onSearchBarClick: () -> Unit) {
    val tabs = listOf(TabItem.Music, TabItem.Movies, TabItem.Books)
    val pagerState = rememberPagerState(tabs.size)
    Spacer(modifier = Modifier.height(36.dp))
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp, bottom = 20.dp),
            fontSize = 28.sp,
            text = "???????????? ???????? ?????????????? ???????????????? ??????????????!",
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            fontFamily = cera_round_pro_regular,
            color = Color.Black
        )
        SearchBar(onSearchBarClick = { onSearchBarClick() })
        Spacer(modifier = Modifier.height(16.dp))
        Promotions()
        Spacer(modifier = Modifier.height(16.dp))
        Tabs(tabs = tabs, pagerState = pagerState)
        TabsContent(tabs = tabs, pagerState = pagerState)
//        BestSellerSection(onClick = {onClick()})
//        Spacer(modifier = Modifier.height(16.dp))
//        NewSection(onClick = {onClick()})
//        Spacer(modifier = Modifier.height(60.dp))
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
    Text(
        modifier = Modifier.padding(20.dp),
        text = "?????????? ?? ??????????????",
        fontFamily = cera_round_pro_regular,
        color = Color(0xFF2B3046),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold)
    LazyRow(
        Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "???????????? ??????????????",
                subtitle = "????",
                header = "160???",
                backgroundColor = Color(0xFF2B3046)
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "????????????",
                subtitle = "???? ??????????????????",
                header = "20%",
                backgroundColor = Color(0xFFE17546)
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "????????????????????",
                subtitle = "????????",
                header = "13:00 - 16:00",
                backgroundColor = Color(0xFFFBC370)
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.mipmap.ic_launcher_foreground),
                title = "????",
                subtitle = "??????????????????",
                header = "??????!",
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
fun BestSellerSection(onClick: () -> Unit) {
    Column() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "????????????????????",
                fontFamily = cera_round_pro_regular,
                color = Color(0xFF2B3046),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
            TextButton(onClick = {}) {
                Text(text = "??????????????????", color = Color(0xFF2B3046))
            }
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(MainActivity().getListOfProducts()) { filteredCountries: Array<String> ->
                CardItem(
                    countryText = filteredCountries,
                    onItemClick = { selectedCountry ->
                        onClick()
                    }
                )
            }
        }
    }
}



@Composable
fun NewSection(onClick: () -> Unit) {
    Column() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "??????????????",
                fontFamily = cera_round_pro_regular,
                color = Color(0xFF2B3046),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
            TextButton(onClick = {}) {
                Text(text = "??????????????????", color = Color(0xFF2B3046 ))
            }
        }
        LazyRow(
            contentPadding = PaddingValues(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(MainActivity().getListOfProducts()) { filteredCountries: Array<String> ->
                CardItem(
                    countryText = filteredCountries,
                    onItemClick = { selectedCountry ->
                        onClick()
                    }
                )
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    // OR ScrollableTabRow()
    TabRow(
        // Our selected tab is our current page
        selectedTabIndex = pagerState.currentPage,
        // Override the indicator, using the provided pagerTabIndicatorOffset modifier
        backgroundColor = Color.White,
        contentColor = Color.White,
        modifier = Modifier
            .padding(20.dp)
            .background(color = White)
            .clip(RoundedCornerShape(30.dp)),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .pagerTabIndicatorOffset(pagerState, tabPositions)
                    .size(0.dp)
            )
        }) {

        

        // Add tabs for all of our pagess
        tabs.forEachIndexed { index, tab ->
            val color = remember {
                Animatable(PrimaryColor)
            }
            LaunchedEffect(pagerState.currentPage == index){
                color.animateTo(if(pagerState.currentPage == index) PrimaryColor else White)
            }
            Tab(
                text = { Text(tab.title, style = if (pagerState.currentPage == index)
                    TextStyle(color = Black)
                else TextStyle(color = White)
                ) },
                modifier = Modifier.background(color = color.value, shape = RoundedCornerShape(30.dp)),
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}
@Composable
@Preview
fun Preview(){
    HomeContent(onClick = { /*TODO*/ }) {
        
    }
}








