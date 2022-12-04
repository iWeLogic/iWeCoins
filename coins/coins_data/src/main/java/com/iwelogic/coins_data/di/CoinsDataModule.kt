package com.iwelogic.coins_data.di

import com.iwelogic.coins_data.datasource.CoinsDataSource
import com.iwelogic.coins_data.remote.CoinsApi
import com.iwelogic.coins_data.repository.CoinsRepositoryImp
import com.iwelogic.coins_domain.repository.CoinsRepository
import com.iwelogic.core.BuildConfig
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
            .baseUrl(BuildConfig.BACKEND_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CoinsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinsRepository(coinsDataSource: CoinsDataSource): CoinsRepository {
        return CoinsRepositoryImp(coinsDataSource)
    }
}
