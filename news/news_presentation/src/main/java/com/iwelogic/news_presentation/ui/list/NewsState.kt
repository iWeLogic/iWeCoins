package com.iwelogic.news_presentation.ui.list

import com.iwelogic.news_presentation.models.News

sealed class NewsState {
    object Loading : NewsState()
    object Error : NewsState()
    data class NewsData(val news: List<News>) : NewsState()
}

