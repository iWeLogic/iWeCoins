package com.iwelogic.news_presentation.models

data class News(

    var id: String? = null,
    var publishedOn: Long? = null,
    var imageurl: String? = null,
    var title: String? = null,
    var url: String? = null,
    var body: String? = null,
    var tags: String? = null,
    var categories: String? = null,
    var upvotes: String? = null,
    var downvotes: String? = null,
    var lang: String? = null,
    var sourceInfo: SourceInfo? = null
)