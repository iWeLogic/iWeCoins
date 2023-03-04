package com.iwelogic.news_domain.use_case

import com.iwelogic.news_domain.models.NewsDomain

interface NewsUseCase {
    suspend fun getNews(): Result<List<NewsDomain>>
}

