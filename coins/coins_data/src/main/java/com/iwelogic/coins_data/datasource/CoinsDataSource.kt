package com.iwelogic.coins_data.datasource

import android.util.ArrayMap
import com.iwelogic.coins_data.dto.CoinDetailsDto
import com.iwelogic.coins_data.dto.CoinDto
import com.iwelogic.coins_data.dto.CoinHistoryDataDto
import com.iwelogic.coins_data.remote.CoinHistoryApi
import com.iwelogic.coins_data.remote.CoinsApi
import com.iwelogic.core.base.datasource.BaseDataSource
import javax.inject.Inject

class CoinsDataSource @Inject constructor(private val api: CoinsApi, private val historyApi: CoinHistoryApi) : BaseDataSource() {

    suspend fun getCoins(): Result<List<CoinDto>> {
        return getResponse(request = { api.getCoins() })
    }

    suspend fun getCoinDetails(id: String, queries: HashMap<String, Any>): Result<CoinDetailsDto> {
        return getResponse(request = { api.getDetails(id, queries) })
    }

    suspend fun getCoinHistory(queries: HashMap<String, Any>): Result<CoinHistoryDataDto> {
        return getResponse(request = { historyApi.getHistory(queries) })
    }
}