package com.iwelogic.coins_data.mapper

import com.iwelogic.coins_data.dto.CoinDescriptionDto
import com.iwelogic.coins_domain.models.CoinDescriptionDomain

fun CoinDescriptionDto.toCoinDescriptionDomain(): CoinDescriptionDomain {
    return CoinDescriptionDomain(
        en = this.en
    )
}