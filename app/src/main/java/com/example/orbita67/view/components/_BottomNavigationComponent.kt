package com.example.orbita67.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.orbita67.R


object _BottomNavigationComponent {
    @Composable
    fun BottomNavigationBar(items: List<String>, selectedItem: Int, onSelectedItem: (index:Int) -> Unit){
        val purple: Color = Color(red = 0x2B, green = 0x30, blue = 0x46, alpha = 0xFF)

        Box(modifier = Modifier.fillMaxWidth()){
            BottomNavigation(
                modifier = Modifier
                    .padding(bottom = 20.dp, start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(50)),
                elevation = 10.dp,
                backgroundColor = purple
            ) {
                items.forEachIndexed{ index, item ->
                    BottomNavigationItem(
                        icon = {
                            when(index) {
                                0 -> {
                                    Icon(painter = painterResource(R.drawable.ic_home), contentDescription = null)
                                }
                                1 -> {
                                    Icon(painter = painterResource(R.drawable.ic_search), contentDescription = null)
                                }
                                2 -> {
                                    Icon(painter = painterResource(R.drawable.ic_favourites), contentDescription = null)
                                }
                                3 -> {
                                    Icon(painter = painterResource(R.drawable.ic_profile), contentDescription = null)
                                }

                            }
                        },
                        selected = selectedItem == index,
                        onClick = {
                            if(index==1){
                                //Toast.makeText(this@Column, "Hello", Toast.LENGTH_SHORT).show()
                            }
                            onSelectedItem(index)

                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Gray
                    )
                }
            }
        }
    }









    @Composable
    fun TopAppBar() {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    Alignment.Center) {
                    Text(text = "Top App Bar")
                } },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription = "Icon")
                }
            },
            modifier= Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .clip(shape = RoundedCornerShape(16.dp)),
            backgroundColor = Color(0xFFFBC370),
            contentColor = Color(0xFF442c2E),
            elevation = 8.dp,
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null)
                }
            }
        )
    }

}