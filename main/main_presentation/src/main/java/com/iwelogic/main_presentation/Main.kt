package com.iwelogic.main_presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iwelogic.coins_presentation.ui.list.CoinsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = Color.White
    )
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Coins.route) {
        composable(NavigationItem.Coins.route) {
            CoinsScreen(NavigationItem.Coins.title)
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen()
        }
    }
}

@Composable
fun SettingsScreen() {
    Text(text = "SettingsScreen", fontSize = 18.sp)
}