package com.myteacher.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myteacher.ui.screens.login.AuthorizationPage
import com.myteacher.ui.screens.login.RegistrationPage

fun NavGraphBuilder.loginScreenNavGraph(navController: NavHostController) {
    navigation(
        route = Routes.Screen.Login.route,
        startDestination = Routes.Page.Authorization.route
    ) {
        composable(route = Routes.Page.Authorization.route) {
            AuthorizationPage(navController = navController)
        }

        composable(route = Routes.Page.Registration.route) {
            RegistrationPage(navController = navController)
        }
    }
}