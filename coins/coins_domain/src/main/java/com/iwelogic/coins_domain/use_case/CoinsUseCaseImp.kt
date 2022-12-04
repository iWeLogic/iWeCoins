package com.iwelogic.coins_domain.use_case

import com.iwelogic.coins_domain.models.CoinDomain
import com.iwelogic.coins_domain.repository.CoinsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinsUseCaseImp(private val repository: CoinsRepository) : CoinsUseCase {

    override suspend fun getCoins(): Result<List<CoinDomain>> = withContext(Dispatchers.IO) {
        repository.getCoins()
    }
}

