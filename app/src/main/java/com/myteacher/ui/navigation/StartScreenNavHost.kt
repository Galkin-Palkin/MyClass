package com.myteacher.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myteacher.ui.screens.start.AuthorizationPage
import ru.virtaulelectrics.common.BuildConfig

@Composable
fun StartScreenNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "authorization") {
        composable("authorization") {  }
        composable("registration") {  }
        composable("first_data") {  }
        composable("contacts") {  }
        composable("") {}
    }


}