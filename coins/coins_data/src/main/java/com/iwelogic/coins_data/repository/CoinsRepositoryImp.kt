package com.iwelogic.coins_data.repository

import com.iwelogic.coins_data.datasource.CoinsDataSource
import com.iwelogic.coins_data.mapper.toCoinDomain
import com.iwelogic.coins_domain.models.CoinDomain
import com.iwelogic.coins_domain.repository.CoinsRepository

class CoinsRepositoryImp (private val coinsDataSource: CoinsDataSource) : CoinsRepository {

    override suspend fun getCoins(): Result<List<CoinDomain>> {
        return coinsDataSource.getCoins().map { result ->
            result.map { it.toCoinDomain() }
        }
    }
}