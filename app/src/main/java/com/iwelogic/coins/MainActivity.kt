package com.iwelogic.coins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.iwelogic.coins.navigation.AppNavigation
import com.iwelogic.core_ui.Route
import com.iwelogic.coins.theme.iWeCoinsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            iWeCoinsTheme {
                AppNavigation(navController = rememberAnimatedNavController(), Route.MAIN)
            }
        }
    }
}

