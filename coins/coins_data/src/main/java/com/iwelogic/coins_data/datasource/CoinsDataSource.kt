package com.iwelogic.coins_data.datasource

import com.iwelogic.coins_data.remote.CoinsApi
import com.iwelogic.core.base.datasource.BaseDataSource
import com.iwelogic.coins_data.dto.CoinDto
import javax.inject.Inject

class CoinsDataSource @Inject constructor(private val api: CoinsApi) : BaseDataSource() {

    suspend fun getCoins(): Result<List<CoinDto>> {
        return getResponse(request = { api.getCoins() })
    }
}