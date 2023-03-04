package com.iwelogic.coins_presentation.mapper

import com.iwelogic.coins_domain.models.CoinHistoryDomain
import com.iwelogic.coins_presentation.models.CoinHistory

fun CoinHistoryDomain.toCoinHistory(): CoinHistory {
    return CoinHistory(
        time = this.time,
        open = this.open,
        close = this.close,
        high = this.high,
        low = this.low,
        volumeFrom = this.volumeFrom,
        volumeTo = this.volumeTo
    )
}