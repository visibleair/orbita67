package com.example.orbita67.model.graphs

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.orbita67.MainViewModel
import com.example.orbita67.ui.authorization.DetailsScreen
import com.example.orbita67.ui.home.MoviesScreen
import com.example.orbita67.view.screens.CodeAccept
import com.example.orbita67.view.screens.LoginScreen
import com.example.orbita67.view.screens.RegisterScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController, viewModel: MainViewModel) {
    navigation(
        route = "auth_graph",
        startDestination = "LOGIN"
    ) {
        composable(route = "LOGIN") {
            LoginScreen(
                onClick = {
                    navController.navigate("FORGOT")
                },
                onSignUpClick = {
                    navController.navigate("SIGN_UP")
                },
                onForgotClick = {
                    navController.popBackStack()
                    navController.navigate("home_graph")
                }
            )
        }
        composable(route = "SIGN_UP") {
            MoviesScreen(navController = navController,viewModel = viewModel)
        }
        composable(route = "DETAILS" + "/{Id}") { backStackEntry ->
            DetailsScreen(viewModel = viewModel, itemId = backStackEntry.arguments?.getString("Id")?: "1" )
        }
        composable(route = "FORGOT") {
            CodeAccept (
                onClick = {
                    navController.popBackStack()
                    navController.navigate("home_graph")
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}