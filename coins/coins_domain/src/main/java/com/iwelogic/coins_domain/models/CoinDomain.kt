package com.iwelogic.coins_domain.models

data class CoinDomain(
    val priceChangePercentage24h: Double? = null,
    val symbol: String? = null,
    val image: String? = null,
    val priceChange24h: Double? = null,
    val name: String? = null,
    val id: String? = null,
    val currentPrice: Double? = null
)