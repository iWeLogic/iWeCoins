package com.iwelogic.coins_data.mapper

import com.iwelogic.coins_data.dto.CoinDetailsDto
import com.iwelogic.coins_domain.models.CoinDomain
import com.iwelogic.coins_data.dto.CoinDto
import com.iwelogic.coins_domain.models.CoinDetailsDomain

fun CoinDetailsDto.toCoinDetailsDomain(): CoinDetailsDomain {
    return CoinDetailsDomain(
        description = this.description?.toCoinDescriptionDomain()

    )
}