package com.iwelogic.coins_domain.repository

import com.iwelogic.coins_domain.models.CoinDomain

interface CoinsRepository {
    suspend fun getCoins(): Result<List<CoinDomain>>
}