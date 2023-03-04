package com.iwelogic.coins_domain.repository

import com.iwelogic.coins_domain.models.CoinDetailsDomain
import com.iwelogic.coins_domain.models.CoinDomain
import com.iwelogic.coins_domain.models.CoinHistoryDataDomain

interface CoinsRepository {

    suspend fun getCoins(): Result<List<CoinDomain>>

    suspend fun getCoinDetails(id: String, queries: HashMap<String, Any>): Result<CoinDetailsDomain>

    suspend fun getCoinHistory(queries: HashMap<String, Any>): Result<CoinHistoryDataDomain>
}