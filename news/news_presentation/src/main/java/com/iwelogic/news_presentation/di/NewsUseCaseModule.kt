package com.iwelogic.news_presentation.di

import com.iwelogic.news_domain.repository.NewsRepository
import com.iwelogic.news_domain.use_case.NewsUseCase
import com.iwelogic.news_domain.use_case.NewsUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object NewsUseCaseModule {

    @Provides
    fun provide(coinsRepository: NewsRepository): NewsUseCase {
        return NewsUseCaseImp(coinsRepository)
    }
}