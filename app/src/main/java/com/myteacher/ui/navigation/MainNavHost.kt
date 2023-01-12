package com.myteacher.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Screen.Login.route,
        route = Routes.MainRoute
    ) {
        loginScreenNavGraph(navController = navController)

        firstDataScreenNavGraph(navController = navController)
    }
}