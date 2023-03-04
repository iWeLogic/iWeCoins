package com.iwelogic.coins_data.di

import com.iwelogic.coins_data.BuildConfig.BACKEND_URL
import com.iwelogic.coins_data.BuildConfig.HISTORY_BASE_URL
import com.iwelogic.coins_data.datasource.CoinsDataSource
import com.iwelogic.coins_data.remote.CoinHistoryApi
import com.iwelogic.coins_data.remote.CoinsApi
import com.iwelogic.coins_data.repository.CoinsRepositoryImp
import com.iwelogic.coins_domain.repository.CoinsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoinsDataModule {

    @Provides
    @Singleton
    fun provideCoinsApi(builder: Retrofit.Builder, client: OkHttpClient): CoinsApi {
        return builder
            .baseUrl(BACKEND_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CoinsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinHistoryApi(builder: Retrofit.Builder, client: OkHttpClient): CoinHistoryApi {
        return builder
            .baseUrl(HISTORY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CoinHistoryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinsRepository(coinsDataSource: CoinsDataSource): CoinsRepository {
        return CoinsRepositoryImp(coinsDataSource)
    }
}
