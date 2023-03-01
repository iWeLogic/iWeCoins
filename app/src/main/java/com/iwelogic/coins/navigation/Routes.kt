package com.iwelogic.coins.navigation

sealed class Routes(val route: String) {
    object Main : Routes("main")
    object CoinDetails : Routes("coinDetails")
}
