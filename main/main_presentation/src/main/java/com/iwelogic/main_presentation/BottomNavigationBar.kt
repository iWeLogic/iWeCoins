package com.iwelogic.main_presentation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.iwelogic.core.utils.isTrue

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Coins,
        NavigationItem.News
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.onPrimary.copy(0.5f),
                alwaysShowLabel = true,
                selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == item.route }.isTrue(),
                onClick = {
                    navController.navigate(
                        item.route
                    ) {
                        anim {
                            enter = R.anim.empty_anim
                            exit = R.anim.empty_anim
                            popEnter = R.anim.empty_anim
                            popExit = R.anim.empty_anim
                        }
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}