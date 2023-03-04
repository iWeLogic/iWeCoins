package com.iwelogic.coins_domain.use_case

import com.iwelogic.coins_domain.models.CoinDomain

interface CoinsUseCase {

    suspend fun getCoins(): Result<List<CoinDomain>>
}

