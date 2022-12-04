package com.iwelogic.coins_data.repository

import com.iwelogic.coins_data.datasource.CoinsDataSource
import com.iwelogic.coins_data.mapper.toCoin
import com.iwelogic.coins_domain.models.Coin
import com.iwelogic.coins_domain.repository.CoinsRepository

class CoinsRepositoryImp (private val coinsDataSource: CoinsDataSource) : CoinsRepository {

    override suspend fun getCoins(): Result<List<Coin>> {
        return coinsDataSource.getCoins().map { result ->
            result.map { it.toCoin() }
        }
    }
}