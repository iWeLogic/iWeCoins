package com.iwelogic.coins_data.remote

import com.iwelogic.coins_data.dto.CoinHistoryDataDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CoinHistoryApi {

    @GET("data/histoday")
    suspend fun getHistory(@QueryMap queries: HashMap<String, Any>): Response<CoinHistoryDataDto>
}