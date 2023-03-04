package com.iwelogic.coins_presentation.mapper

import com.iwelogic.coins_domain.models.CoinHistoryDataDomain
import com.iwelogic.coins_presentation.models.CoinHistoryData

fun CoinHistoryDataDomain.toCoinHistoryData(): CoinHistoryData {
    return CoinHistoryData(
        data = this.data?.map { it.toCoinHistory() }
    )
}