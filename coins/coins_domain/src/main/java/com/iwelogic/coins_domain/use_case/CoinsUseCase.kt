package com.iwelogic.coins_domain.use_case

import com.iwelogic.coins_domain.models.Coin
import com.iwelogic.coins_domain.repository.CoinsRepository
import javax.inject.Inject

class CoinsUseCase @Inject constructor(private val repository: CoinsRepository) {

    suspend fun getCoins(): Result<List<Coin>> {
        return repository.getCoins()
    }
}

