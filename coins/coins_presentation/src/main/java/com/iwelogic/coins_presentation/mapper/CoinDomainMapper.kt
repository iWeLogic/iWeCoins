package com.iwelogic.coins_presentation

import com.iwelogic.coins_domain.models.CoinDomain
import com.iwelogic.coins_presentation.models.Coin

fun CoinDomain.toCoin(): Coin {
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