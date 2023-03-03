package com.iwelogic.news_presentation.ui.list

import com.iwelogic.news_domain.models.News

sealed class NewsEvent {
    data class OpenNewsDetails(val news: News) : NewsEvent()
}
