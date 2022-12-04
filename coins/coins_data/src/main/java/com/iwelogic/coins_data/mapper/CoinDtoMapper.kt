package com.iwelogic.coins_data.mapper

import com.iwelogic.coins_domain.models.Coin
import com.iwelogic.coins_data.dto.CoinDto

fun CoinDto.toCoin(): Coin {
    return Coin(
        priceChangePercentage24h = priceChangePercentage24h,
        symbol = symbol,
        image = image,
        priceChange24h = priceChange24h,
        name = name,
        id = id,
        currentPrice = currentPrice
    )
}