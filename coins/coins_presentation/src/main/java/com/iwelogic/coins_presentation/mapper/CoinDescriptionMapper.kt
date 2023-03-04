package com.iwelogic.coins_presentation.mapper

import com.iwelogic.coins_domain.models.CoinDescriptionDomain
import com.iwelogic.coins_presentation.models.CoinDescription

fun CoinDescriptionDomain.toCoinDescription(): CoinDescription {
    return CoinDescription(
        en = this.en
    )
}