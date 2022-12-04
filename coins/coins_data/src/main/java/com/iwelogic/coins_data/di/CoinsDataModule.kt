package com.iwelogic.coins_data.di

import com.iwelogic.coins_data.datasource.CoinsDataSource
import com.iwelogic.coins_data.remote.CoinsApi
import com.iwelogic.coins_data.repository.CoinsRepositoryImp
import com.iwelogic.coins_domain.repository.CoinsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoinsDataModule {

    @Provides
    @Singleton
    fun provideCoinsApi(retrofit: Retrofit): CoinsApi {
        return retrofit.create(CoinsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinsRepository(coinsDataSource: CoinsDataSource): CoinsRepository {
        return CoinsRepositoryImp(coinsDataSource)
    }
}
