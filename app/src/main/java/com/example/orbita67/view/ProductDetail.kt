package com.example.orbita67.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orbita67.R
import com.example.orbita67.ui.theme.*
import com.example.orbita67.view.components._BottomNavigationComponent
import com.example.orbita67.view.components._Button
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch


object ProductDetail {
    private val productName = "Капучино"
    private val productCost = "200"
    private val productDescription = "Классический кофейный напиток на основе эспрессо и взбитого молока."
    private val productNameTextSize = 20.sp
    private val productConstTextSize = 20.sp
    private val productDescriptionTextSize = 15.sp

    private val productContentPaddingHorizontal = 20.dp
    private val productContentPaddingVertical = 20.dp
    private val productNamePaddingBottom = 10.dp
    private val productConstGap = 10.dp
    private val productConstPaddingBottom = 15.dp


    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun ProductDetail(){
        val items = listOf("menu1", "menu2", "menu3", "menu4")
        var selectedItem by remember {
            mutableStateOf(0)
        }
        
        Scaffold(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxHeight()
        ) {
            Column(
                Modifier.fillMaxHeight(1f)) {
                Column() {
                    Box(modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth()
                        .background(Color.Black),
                    contentAlignment = Alignment.Center){
                        Image(
                            painter = painterResource(R.drawable.cup),
                            contentDescription = ""
                            )
                    }

                    Card(Modifier.background(Color.Black).fillMaxHeight(), shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight()){
                            Text (
                                text = productName,
                                fontSize = productNameTextSize,
                                modifier = Modifier.padding(vertical = 10.dp),
                                fontWeight = FontWeight.Bold,
                            )
                            Text (
                                modifier =  Modifier.padding(horizontal = 20.dp),
                                textAlign = TextAlign.Center,
                                text = productDescription,
                                fontSize = productDescriptionTextSize,
                            )
                            Row(modifier = Modifier.padding(20.dp)) {

                                CoffeeSizeTabs(pagerState = PagerState(4))
                            }
                            Row(){
                                Text(text = "О напитке")

                            }
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(vertical = 20.dp),
                                verticalAlignment = Alignment.Bottom
                            ){

                                _Button.MainButton (
                                    width = 500,
                                    function = {},
                                    text = "В корзину 120₽"
                                )
                            }
                        }




                    }

                }


            }

        }







    }
}
@Preview
@Composable
fun Preview(){
    ProductDetail.ProductDetail()
}

@ExperimentalPagerApi
@Composable
fun CoffeeSizeTabs(pagerState: PagerState) {

    val list = listOf("S", "M", "L", "XL")

    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = PrimaryColor,
        divider = {
            TabRowDefaults.Divider(
                thickness = 3.dp,
                color = Color.White
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                    .padding(horizontal = 25.dp),
                height = 3.dp

            )


        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        text = list[index],
                        color = if (pagerState.currentPage == index) PrimaryColor else Color.Gray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }

    }
}



@ExperimentalMaterialApi
@Composable
fun DropDownList(icon: Int, mainText: String, subText: String, onClick: () -> Unit) {
    Card(
        onClick = { onClick() },
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(shape = Shapes.medium)
                        .background(LightPrimaryColor)
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))
                Column(
                    modifier = Modifier.offset(y = (2).dp)
                ) {
                    Text(
                        text = mainText,
                        fontFamily = cera_round_pro_regular,
                        color = SecondaryColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = subText,
                        fontFamily = cera_round_pro_regular,
                        color = Color.Gray,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.offset(y = (-4).dp)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_favourites),
                contentDescription = "",
                modifier = Modifier.size(16.dp)
            )

        }
    }
}


