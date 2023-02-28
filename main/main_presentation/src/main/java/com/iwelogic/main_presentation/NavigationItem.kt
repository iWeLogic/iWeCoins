package com.iwelogic.main_presentation

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Coins : NavigationItem("coins", R.drawable.coins, "Coins")
    object News : NavigationItem("news", R.drawable.news, "News")
}
