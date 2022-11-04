package com.example.orbita67.view.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.unit.dp
import com.example.orbita67.ui.theme.PrimaryColor
import com.example.orbita67.view.screens.HomeScreen.TabScreenOne
import com.example.orbita67.view.screens.HomeScreen.TabScreenThree
import com.example.orbita67.view.screens.HomeScreen.TabScreenTwo
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@Composable
fun ProfileContent(onClick: () -> Unit) {

}



@ExperimentalPagerApi
@Composable
fun TabScreen(){
    val pagerState = rememberPagerState(pageCount = 4)

    Column (
        modifier = Modifier.background(Color.White)
    )
    {
        Tabs(pagerState= pagerState)
        TabsContent(pagerState = pagerState)

    }

}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {

    val list = listOf("Напитки", "Еда", "Закуски", "Десерты")

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
                Modifier.pagerTabIndicatorOffset(pagerState,tabPositions).padding(horizontal = 25.dp),
                height = 3.dp

            )


        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(text = list[index],
                        color = if (pagerState.currentPage == index) PrimaryColor else Color.Gray
                    )
                },
                selected = pagerState.currentPage == index ,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }

    }



}


@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {

    HorizontalPager(state = pagerState) { page ->
        when (page){
            0->TabScreenOne()
            1-> TabScreenTwo()
            2-> TabScreenThree()
            3-> TabScreenThree()
        }

    }

}
