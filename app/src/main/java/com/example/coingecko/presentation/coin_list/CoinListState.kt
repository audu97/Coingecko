package com.example.coingecko.presentation.coin_list

import com.example.coingecko.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = true,
    val coins: List<Coin> = emptyList(),
    val error: String = " "
)
