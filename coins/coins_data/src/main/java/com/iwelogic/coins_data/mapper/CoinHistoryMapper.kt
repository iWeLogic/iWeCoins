package com.iwelogic.coins_data.mapper

import com.iwelogic.coins_data.dto.CoinHistoryDto
import com.iwelogic.coins_domain.models.CoinHistoryDomain

fun CoinHistoryDto.toCoinHistoryDomain(): CoinHistoryDomain {
    return CoinHistoryDomain(
        time = this.time,
        open = this.open,
        close = this.close,
        high = this.high,
        low = this.low,
        volumeFrom = this.volumeFrom,
        volumeTo = this.volumeTo
    )
}