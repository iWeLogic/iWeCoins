package com.iwelogic.coins_data.remote

import com.iwelogic.coins_data.dto.CoinDetailsDto
import com.iwelogic.coins_data.dto.CoinDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface CoinsApi {

    @GET("coins/markets")
    suspend fun getCoins(@Query("order") order: String = "market_cap_desc", @Query("vs_currency") vsCurrency: String = "usd"): Response<List<CoinDto>>

    @GET("coins/{id}")
    suspend fun getDetails(@Path("id") id: String, @QueryMap queries: HashMap<String, Any>): Response<CoinDetailsDto>
}