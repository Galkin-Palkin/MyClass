package com.myteacher.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun StartScreenNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "authorization") {
        composable("authorization") {  }
        composable("registration") {  }
    }
}