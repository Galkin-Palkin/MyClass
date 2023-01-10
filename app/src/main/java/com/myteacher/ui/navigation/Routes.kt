package com.myteacher.ui.navigation

object Routes {
    const val MainRoute = "main"

    sealed class Page(val route: String) {
        object Authorization: Page("authorization_page")

        object Registration: Page("registration_page")

        object Data: Page("data_page")

        object Contacts: Page("contacts_page")

        object Role: Page("role_page")
    }

    sealed class Screen(val route: String) {
        object Login: Screen("login_screen")

        object FirstData: Screen("first_data_screen")

        object Home: Screen("home_screen")
    }
}