package com.iwelogic.coins_domain.models

data class CoinDomain(
    val priceChangePercentage24h: Float? = null,
    val symbol: String? = null,
    val image: String? = null,
    val priceChange24h: Float? = null,
    val name: String? = null,
    val id: String? = null,
    val currentPrice: Float? = null
)