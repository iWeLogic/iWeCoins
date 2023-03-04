package com.iwelogic.coins_data.repository

import android.util.ArrayMap
import com.iwelogic.coins_data.datasource.CoinsDataSource
import com.iwelogic.coins_data.mapper.toCoinDetailsDomain
import com.iwelogic.coins_data.mapper.toCoinDomain
import com.iwelogic.coins_data.mapper.toCoinHistoryDataDomain
import com.iwelogic.coins_domain.models.CoinDetailsDomain
import com.iwelogic.coins_domain.models.CoinDomain
import com.iwelogic.coins_domain.models.CoinHistoryDataDomain
import com.iwelogic.coins_domain.repository.CoinsRepository

class CoinsRepositoryImp (private val coinsDataSource: CoinsDataSource) : CoinsRepository {

    override suspend fun getCoins(): Result<List<CoinDomain>> {
        return coinsDataSource.getCoins().map { result ->
            result.map { it.toCoinDomain() }
        }
    }

    override suspend fun getCoinDetails(id: String, queries: HashMap<String, Any>): Result<CoinDetailsDomain> {
        return coinsDataSource.getCoinDetails(id, queries).map { result ->
            result.toCoinDetailsDomain()
        }
    }

    override suspend fun getCoinHistory(queries: HashMap<String, Any>): Result<CoinHistoryDataDomain> {
        return coinsDataSource.getCoinHistory(queries).map { result ->
            result.toCoinHistoryDataDomain()
        }
    }
}