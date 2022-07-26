package com.example.coingecko.domain.use_case

import com.example.coingecko.common.Resource
import com.example.coingecko.domain.model.Coin
import com.example.coingecko.domain.model.toCoin
import com.example.coingecko.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins =repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected Error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach Server, check your internet connection"))
        }
    }

}