package com.iwelogic.news_data.mapper

import com.iwelogic.news_data.dto.NewsDto
import com.iwelogic.news_domain.models.NewsDomain
import com.iwelogic.news_domain.models.SourceInfoDomain

fun NewsDto.toNews(): NewsDomain {
    return NewsDomain(
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
        sourceInfo = SourceInfoDomain(
            name = sourceInfo?.name,
            lang = sourceInfo?.lang,
            img = sourceInfo?.img
        )
    )
}