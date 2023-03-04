package com.iwelogic.coins_presentation.models

data class CoinHistory(

    val time: Long?,
    val open: Float? = null,
    val close: Float? = null,
    val high: Float? = null,
    val low: Float? = null,
    val volumeFrom: Float? = null,
    val volumeTo: Float? = null
)
