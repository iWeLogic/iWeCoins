package com.iwelogic.coins_presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coin(
    val priceChangePercentage24h: Double? = null,
    val symbol: String? = null,
    val image: String? = null,
    val priceChange24h: Double? = null,
    val name: String? = null,
    val id: String? = null,
    val currentPrice: Double? = null
) : Parcelable