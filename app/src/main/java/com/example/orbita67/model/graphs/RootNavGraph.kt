package com.example.orbita67.model.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.orbita67.view.screens.HomeScreen


@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = "root_graph",
        startDestination = "auth_graph"
    ) {
        authNavGraph(navController = navController)
        composable(route = "home_graph") {
            HomeScreen()
        }
    }
}

