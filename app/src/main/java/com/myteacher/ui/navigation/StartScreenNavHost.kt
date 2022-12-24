package com.myteacher.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myteacher.ui.screens.start.AuthorizationPage
import com.myteacher.ui.screens.start.RegistrationPage

@Composable
fun StartScreenNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "authorization") {
        composable("authorization") {
            AuthorizationPage( //TODO fix hardcode states
                navController = navController,
                login = "",
                onLoginChanged = {},
                password = "",
                onPasswordChanged = {}
            )
        }
        composable("registration") { RegistrationPage( //TODO fix hardcode states
            navController = navController,
            login = "",
            onLoginChanged = {},
            password = "",
            onPasswordChanged = {}
        )}
        composable("first_data") { }
        composable("contacts") { }
        composable("vertical_main") {}
    }
}