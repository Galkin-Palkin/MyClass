package com.myteacher.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myteacher.ui.screens.firstData.ContactsPage
import com.myteacher.ui.screens.firstData.DataPage
import com.myteacher.ui.screens.firstData.RolePage

fun NavGraphBuilder.firstDataScreenNavGraph(navController: NavHostController) {
    navigation(
        route = Routes.Screen.FirstData.route,
        startDestination = Routes.Page.Data.route
    ) {
        composable(route = Routes.Page.Data.route) {
            DataPage(navController = navController)
        }

        composable(route = Routes.Page.Contacts.route) {
            ContactsPage(navController = navController)
        }

        composable(route = Routes.Page.Role.route) {
            RolePage(navController = navController)
        }
    }
}