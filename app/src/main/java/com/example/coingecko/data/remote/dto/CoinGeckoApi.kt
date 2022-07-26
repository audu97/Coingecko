package com.example.coingecko.data.remote.dto

import retrofit2.http.GET

interface CoinGeckoApi {
    @GET("coins/list")
    suspend fun getCoins(): List<CoinListItemDto>
}