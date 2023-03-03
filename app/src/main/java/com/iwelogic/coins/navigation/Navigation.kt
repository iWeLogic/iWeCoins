package com.iwelogic.coins.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.iwelogic.coins_presentation.ui.details.CoinDetailsScreen
import com.iwelogic.core_ui.Route
import com.iwelogic.main_presentation.MainScreen
import com.iwelogic.news_presentation.ui.details.NewsDetailsScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController, startDestination: String) {

    AnimatedNavHost(navController = navController, startDestination = startDestination) {
        composable(Route.MAIN,
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
            MainScreen {
                if (it.startsWith(Route.NAVIGATION_UP)) {
                    navController.navigateUp()
                } else {
                    navController.navigate(it)
                }
            }
        }
        composable(Route.COIN_DETAILS,
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
            CoinDetailsScreen(navigate = {
                if (it.startsWith(Route.NAVIGATION_UP)) {
                    navController.navigateUp()
                } else {
                    navController.navigate(it)
                }
            })
        }
        composable(
            route = Route.NEWS_DETAILS + "/{url}",
            arguments = listOf(
                navArgument("url") {
                    type = NavType.StringType
                }
            ),
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
        ) { entry ->
            NewsDetailsScreen(entry.arguments?.getString("url"), navigate = {
                if (it.startsWith(Route.NAVIGATION_UP)) {
                    navController.navigateUp()
                } else {
                    navController.navigate(it)
                }
            })
        }
    }
}