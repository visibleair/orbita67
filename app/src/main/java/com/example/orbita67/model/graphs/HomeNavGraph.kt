package com.example.orbita67.model.graphs

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.orbita67.BottomBarScreen
import com.example.orbita67.ui.home.ProductDetail.ProductDetail
import com.example.orbita67.ui.home.SearchScreenContent
import com.example.orbita67.view.screens.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = "home_graph",
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeContent(
                onClick = {
                    navController.navigate("DETAILS_ROUT")
                },
                onSearchBarClick = {
                    navController.navigate(BottomBarScreen.Search.route)
                }
            )
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreenContent(
                onClick = {
                    navController.navigate("DETAILS_ROUT")
                }
            )
        }
        composable(route = BottomBarScreen.Cart.route) {
            CartContent()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileContent()
        }
        composable(route = "DETAILS_ROUT") {
            ProductDetail()

        }
    }
}



fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = "details_graph",
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            ProductDetail()
        }
        composable(route = DetailsScreen.Overview.route) {
//            ProductDetail()
//                navController.popBackStack(
//                    route = DetailsScreen.Information.route,
//                    inclusive = false
//                )

        }
    }
}


sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
}
