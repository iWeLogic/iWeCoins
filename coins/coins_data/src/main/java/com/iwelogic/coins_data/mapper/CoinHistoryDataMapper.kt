package com.iwelogic.coins_data.mapper

import com.iwelogic.coins_data.dto.CoinHistoryDataDto
import com.iwelogic.coins_domain.models.CoinHistoryDataDomain

fun CoinHistoryDataDto.toCoinHistoryDataDomain(): CoinHistoryDataDomain {
    return CoinHistoryDataDomain(
        data = this.data?.map { it.toCoinHistoryDomain() }
    )
}