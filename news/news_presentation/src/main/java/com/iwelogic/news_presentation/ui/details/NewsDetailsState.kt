package com.iwelogic.news_presentation.ui.details

import com.iwelogic.news_domain.models.News

sealed class NewsDetailsState {
    object Loading : NewsDetailsState()
    object Error : NewsDetailsState()
    data class NewsData(val news: List<News>) : NewsDetailsState()
}

