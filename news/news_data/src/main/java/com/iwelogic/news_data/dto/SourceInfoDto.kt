package com.iwelogic.news_data.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SourceInfoDto(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("lang")
    var lang: String? = null,
    @SerializedName("img")
    var img: String? = null
) : Parcelable