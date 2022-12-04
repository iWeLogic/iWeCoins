package com.iwelogic.news_data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("Type")
    @Expose
    var type: Int? = null,
    @SerializedName("Data")
    @Expose
    var data: MutableList<NewsDto>? = null
) {
}