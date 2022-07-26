package com.example.coingecko.domain.repositories


import com.example.coingecko.data.remote.dto.CoinListItemDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinListItemDto>
}