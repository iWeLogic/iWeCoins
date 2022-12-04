package com.iwelogic.coins_domain.repository

import com.iwelogic.coins_domain.models.Coin

interface CoinsRepository {

    suspend fun getCoins(): Result<List<Coin>>
}