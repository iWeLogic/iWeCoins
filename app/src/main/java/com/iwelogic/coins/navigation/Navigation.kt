package com.iwelogic.coins.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iwelogic.main_presentation.MainScreen

@Composable
fun AppNavigation(navController: NavHostController, startDestination: Routes) {

    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(Routes.Main.route) {
            MainScreen()
        }
    }
}