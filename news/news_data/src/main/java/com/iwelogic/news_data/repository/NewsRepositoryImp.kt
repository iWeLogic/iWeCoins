package com.iwelogic.news_data.repository

import com.iwelogic.news_data.datasource.NewsDataSource
import com.iwelogic.news_data.mapper.toNews
import com.iwelogic.news_domain.models.News
import com.iwelogic.news_domain.repository.NewsRepository

class NewsRepositoryImp(private val coinsDataSource: NewsDataSource) : NewsRepository {

    override suspend fun getNews(): Result<List<News>> {
        return coinsDataSource.getNews().map { result ->
            result.data?.map { it.toNews() } ?: ArrayList()
        }
    }
}