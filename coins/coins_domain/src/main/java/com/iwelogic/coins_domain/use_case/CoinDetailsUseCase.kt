package com.iwelogic.coins_domain.use_case

import com.iwelogic.coins_domain.models.CoinDetailsDomain
import com.iwelogic.coins_domain.models.CoinDomain

interface CoinDetailsUseCase {

    suspend fun getCoinDetails(): Result<CoinDetailsDomain>
}

