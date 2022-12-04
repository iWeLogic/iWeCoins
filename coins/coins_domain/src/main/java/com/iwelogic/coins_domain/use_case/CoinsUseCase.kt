package com.iwelogic.coins_domain.use_case

import com.iwelogic.coins_domain.models.Coin

interface CoinsUseCase {
    suspend fun getCoins(): Result<List<Coin>>
}

