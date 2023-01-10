package com.myteacher.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myteacher.ui.screens.firstData.DataPage
import com.myteacher.ui.screens.firstData.RolePage

fun NavGraphBuilder.firstDataScreenNavGraph(navController: NavHostController) {
    navigation(
        route = Routes.Screen.FirstData.route,
        startDestination = Routes.Page.Authorization.route
    ) {
        composable(route = Routes.Page.Authorization.route) {
            DataPage(navController = navController)
        }

        composable(route = Routes.Page.Contacts.route) {
            //TODO add contacts page
        }

        composable(route = Routes.Page.Role.route) {
            RolePage(navController = navController)
        }
    }
}