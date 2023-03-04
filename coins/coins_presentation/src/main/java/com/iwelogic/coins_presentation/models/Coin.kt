package com.iwelogic.coins_presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coin(
    val priceChangePercentage24h: Float? = null,
    val symbol: String? = null,
    val image: String? = null,
    val priceChange24h: Float? = null,
    val name: String? = null,
    val id: String? = null,
    val currentPrice: Float? = null
) : Parcelable