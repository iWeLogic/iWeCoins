package com.iwelogic.coins_presentation.ui.list

import com.iwelogic.coins_presentation.models.Coin

sealed class CoinsState {
    object Loading : CoinsState()
    object Error : CoinsState()
    data class ScreenData(val coins: List<Coin>) : CoinsState()
}

