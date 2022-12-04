package com.iwelogic.crypto_coins.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class CoinDto(

    @SerializedName("price_change_percentage_24h")
    val priceChangePercentage24h: Double? = null,

    @SerializedName("symbol")
    val symbol: String? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("price_change_24h")
    val priceChange24h: Double? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("current_price")
    val currentPrice: Double? = null

) : Parcelable