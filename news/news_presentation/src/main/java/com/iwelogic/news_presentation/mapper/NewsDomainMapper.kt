package com.iwelogic.news_presentation.mapper

import com.iwelogic.news_domain.models.NewsDomain
import com.iwelogic.news_presentation.models.News
import com.iwelogic.news_presentation.models.SourceInfo


fun NewsDomain.toNews(): News {
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
