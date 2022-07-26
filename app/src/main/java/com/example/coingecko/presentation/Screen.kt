package com.example.coingecko.presentation

sealed class Screen( val route: String){
    object CoinListScreen: Screen(route = "coin_list")
    object SplashScreen: Screen(route = "splash_screen")
}
