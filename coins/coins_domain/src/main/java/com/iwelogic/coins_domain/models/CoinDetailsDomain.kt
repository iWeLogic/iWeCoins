package com.iwelogic.coins_domain.models

data class CoinDetailsDomain(

    var description: CoinDescriptionDomain? = null,

    var history: CoinHistoryDataDomain? = null
)

