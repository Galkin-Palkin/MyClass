package com.myteacher.ui.architecture

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.myteacher.ui.navigation.MainNavHost

@Composable
fun App() {
    MainNavHost(navController = rememberNavController())
}