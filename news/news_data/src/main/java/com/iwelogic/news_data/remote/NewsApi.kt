package com.iwelogic.news_data.remote

import com.iwelogic.news_data.dto.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("data/v2/news/")
    suspend fun getNews(@Query("lang") lang: String = "EN"): Response<NewsResponse>
}