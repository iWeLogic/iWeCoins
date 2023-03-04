package com.iwelogic.news_domain.repository

import com.iwelogic.news_domain.models.NewsDomain

interface NewsRepository {
    suspend fun getNews(): Result<List<NewsDomain>>
}