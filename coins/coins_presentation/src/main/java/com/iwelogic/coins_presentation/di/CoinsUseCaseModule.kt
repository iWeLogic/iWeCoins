package com.iwelogic.coins_presentation.di

import com.iwelogic.coins_domain.repository.CoinsRepository
import com.iwelogic.coins_domain.use_case.CoinsUseCase
import com.iwelogic.coins_domain.use_case.CoinsUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object CoinsUseCaseModule {

    @Provides
    fun provide(coinsRepository: CoinsRepository): CoinsUseCase {
        return CoinsUseCaseImp(coinsRepository)
    }
}