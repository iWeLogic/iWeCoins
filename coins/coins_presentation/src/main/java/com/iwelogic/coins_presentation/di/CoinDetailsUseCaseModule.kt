package com.iwelogic.coins_presentation.di

import com.iwelogic.coins_domain.repository.CoinsRepository
import com.iwelogic.coins_domain.use_case.CoinDetailsUseCase
import com.iwelogic.coins_domain.use_case.CoinsDetailsUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object CoinDetailsUseCaseModule {

    @Provides
    fun provide(coinsRepository: CoinsRepository): CoinDetailsUseCase {
        return CoinsDetailsUseCaseImp(coinsRepository)
    }
}