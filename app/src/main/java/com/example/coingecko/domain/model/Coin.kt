package com.example.coingecko.domain.model

import com.example.coingecko.data.remote.dto.CoinListItemDto

data class Coin(
    val id: String,
    val name: String,
    val symbol: String
)

fun CoinListItemDto.toCoin(): Coin{
    return Coin(
        id = id,
        name = name,
        symbol = symbol
    )
}
