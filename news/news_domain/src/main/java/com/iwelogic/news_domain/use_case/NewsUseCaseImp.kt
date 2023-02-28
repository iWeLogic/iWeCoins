package com.iwelogic.news_domain.use_case

import com.iwelogic.news_domain.models.News
import com.iwelogic.news_domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsUseCaseImp(private val repository: NewsRepository) : NewsUseCase {

    override suspend fun getNews(): Result<List<News>> = withContext(Dispatchers.IO) {
        repository.getNews()
    }
}

