package com.iwelogic.news_data.mapper

import com.iwelogic.news_data.dto.NewsDto
import com.iwelogic.news_domain.models.News
import com.iwelogic.news_domain.models.SourceInfo

fun NewsDto.toNews(): News {
    return News(
        id = id,
        publishedOn = publishedOn,
        imageurl = imageurl,
        title = title,
        url = url,
        body = body,
        tags = tags,
        categories = categories,
        upvotes = upvotes,
        downvotes = downvotes,
        lang = lang,
        sourceInfo = SourceInfo(
            name = sourceInfo?.name,
            lang = sourceInfo?.lang,
            img = sourceInfo?.img
        )
    )
}