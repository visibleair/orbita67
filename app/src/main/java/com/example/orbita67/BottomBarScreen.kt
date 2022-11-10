package com.example.orbita67

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "HOME",
        icon = Icons.Default.Home
    )

    object Search : BottomBarScreen(
        route = "NOTIFICATIONS",
        icon = Icons.Default.Search
    )
    
    object Cart : BottomBarScreen(
        route = "SHOP-CART",
        icon = Icons.Default.ShoppingCart
    )

    object Profile : BottomBarScreen(
        route = "PROFILE",
        icon = Icons.Default.Person
    )
    
}
