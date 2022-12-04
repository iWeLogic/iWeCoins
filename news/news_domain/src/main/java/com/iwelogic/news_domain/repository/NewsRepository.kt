package com.iwelogic.news_domain.repository

import com.iwelogic.news_domain.models.News

interface NewsRepository {
    suspend fun getNews(): Result<List<News>>
}