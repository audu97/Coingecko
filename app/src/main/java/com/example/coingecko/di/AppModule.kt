package com.example.coingecko.di

import com.example.coingecko.common.Constants
import com.example.coingecko.data.remote.dto.CoinGeckoApi
import com.example.coingecko.data.repositories.CoinRepositoryImpl
import com.example.coingecko.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGeckoApi():CoinGeckoApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinGeckoApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }


}