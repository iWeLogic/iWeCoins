package com.iwelogic.coins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.iwelogic.coins.navigation.AppNavigation
import com.iwelogic.coins.navigation.Routes
import com.iwelogic.coins.theme.iWeCoinsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            iWeCoinsTheme {
                AppNavigation(navController = rememberNavController(), Routes.Main)
            }
        }
    }
}

