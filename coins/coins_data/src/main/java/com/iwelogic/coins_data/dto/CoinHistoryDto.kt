package com.iwelogic.coins_data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class CoinHistoryDto(

    @SerializedName("time")
    val time: Long?,

    @SerializedName("open")
    val open: Float? = null,

    @SerializedName("close")
    val close: Float? = null,

    @SerializedName("high")
    val high: Float? = null,

    @SerializedName("low")
    val low: Float? = null,

    @SerializedName("volumefrom")
    val volumeFrom: Float? = null,

    @SerializedName("volumeto")
    val volumeTo: Float? = null
)
