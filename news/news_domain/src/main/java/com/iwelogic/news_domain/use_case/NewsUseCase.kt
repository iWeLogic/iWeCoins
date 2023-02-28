package com.iwelogic.news_domain.use_case

import com.iwelogic.news_domain.models.News

interface NewsUseCase {
    suspend fun getNews(): Result<List<News>>
}

