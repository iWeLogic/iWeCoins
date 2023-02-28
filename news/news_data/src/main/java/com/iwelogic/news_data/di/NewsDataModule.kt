package com.iwelogic.news_data.di

import com.iwelogic.news_data.BuildConfig.HISTORY_BASE_URL
import com.iwelogic.news_data.datasource.NewsDataSource
import com.iwelogic.news_data.remote.NewsApi
import com.iwelogic.news_data.repository.NewsRepositoryImp
import com.iwelogic.news_domain.repository.NewsRepository
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
object NewsDataModule {

    @Provides
    @Singleton
    fun provideCoinsApi(builder: Retrofit.Builder, client: OkHttpClient): NewsApi {
        return builder
            .baseUrl(HISTORY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinsRepository(coinsDataSource: NewsDataSource): NewsRepository {
        return NewsRepositoryImp(coinsDataSource)
    }
}
