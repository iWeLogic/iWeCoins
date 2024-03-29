package com.iwelogic.main_presentation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.iwelogic.coins_presentation.ui.list.CoinsScreen
import com.iwelogic.news_presentation.ui.details.NewsDetailsScreen
import com.iwelogic.news_presentation.ui.list.NewsScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(navigate: (String) -> Unit) {
    val navController = rememberAnimatedNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .background(MaterialTheme.colors.primary)
            ) {
                AnimatedNavHost(navController, startDestination = NavigationItem.Coins.route) {
                    composable(NavigationItem.Coins.route,
                        enterTransition = {
                            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(0))
                        },
                        exitTransition = {
                            slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(0))
                        },
                        popEnterTransition = {
                            slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(0))
                        },
                        popExitTransition = {
                            slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(0))
                        }

                    ) {
                        CoinsScreen(NavigationItem.Coins.title, navigate)
                    }
                    composable(NavigationItem.News.route,
                        enterTransition = {
                            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(0))
                        },
                        exitTransition = {
                            slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(0))
                        },
                        popEnterTransition = {
                            slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(0))
                        },
                        popExitTransition = {
                            slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(0))
                        }
                    ) {
                        NewsScreen(NavigationItem.News.title, navigate)
                    }
                }
            }
        },
        backgroundColor = Color.White
    )
}
