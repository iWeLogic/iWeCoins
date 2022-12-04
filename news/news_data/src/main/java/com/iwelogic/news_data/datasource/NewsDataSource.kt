package com.iwelogic.news_data.datasource

import com.iwelogic.core.base.datasource.BaseDataSource
import com.iwelogic.news_data.dto.NewsResponse
import com.iwelogic.news_data.remote.NewsApi
import javax.inject.Inject

class NewsDataSource @Inject constructor(private val api: NewsApi) : BaseDataSource() {

    suspend fun getNews(): Result<NewsResponse> {
        return getResponse(request = { api.getNews() })
    }
}