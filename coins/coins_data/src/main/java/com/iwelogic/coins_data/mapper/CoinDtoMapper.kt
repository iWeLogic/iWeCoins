package com.iwelogic.coins_data.mapper

import com.iwelogic.coins_domain.models.CoinDomain
import com.iwelogic.coins_data.dto.CoinDto

fun CoinDto.toCoinDomain(): CoinDomain {
    return CoinDomain(
        priceChangePercentage24h = priceChangePercentage24h,
        symbol = symbol,
        image = image,
        priceChange24h = priceChange24h,
        name = name,
        id = id,
        currentPrice = currentPrice
    )
}