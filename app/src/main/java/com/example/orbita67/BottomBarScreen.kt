package com.example.orbita67

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "HOME",
        icon = Icons.Default.Home
    )

    object Favourites : BottomBarScreen(
        route = "SHOP-CART",
        icon = Icons.Default.Person
    )

    object Profile : BottomBarScreen(
        route = "FAVOURITES",
        icon = Icons.Default.Settings
    )
    object Search : BottomBarScreen(
        route = "NOTIFICATIONS",
        icon = Icons.Default.Settings
    )
}
