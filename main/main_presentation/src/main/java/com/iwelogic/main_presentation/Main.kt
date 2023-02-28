package com.iwelogic.main_presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iwelogic.coins_presentation.ui.list.CoinsScreen
import com.iwelogic.news_presentation.ui.list.NewsScreen

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
        composable(NavigationItem.News.route) {
            NewsScreen(NavigationItem.Coins.title)
        }
    }
}
