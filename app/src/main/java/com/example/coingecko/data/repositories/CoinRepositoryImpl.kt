package com.example.coingecko.data.repositories

import com.example.coingecko.data.remote.dto.CoinGeckoApi
import com.example.coingecko.data.remote.dto.CoinListItemDto
import com.example.coingecko.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinGeckoApi
) :CoinRepository{
    override suspend fun getCoins(): List<CoinListItemDto> {
        return api.getCoins()
    }

}