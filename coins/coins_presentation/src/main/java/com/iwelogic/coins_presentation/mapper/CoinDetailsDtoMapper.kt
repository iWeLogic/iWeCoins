package com.iwelogic.coins_presentation.mapper

import com.iwelogic.coins_domain.models.CoinDetailsDomain
import com.iwelogic.coins_presentation.models.CoinDetails

fun CoinDetailsDomain.toCoinDetails(): CoinDetails {
    return CoinDetails(
        description = this.description?.toCoinDescription(),
        history = this.history?.toCoinHistoryData()
    )
}