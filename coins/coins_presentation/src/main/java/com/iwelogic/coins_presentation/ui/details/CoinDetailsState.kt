package com.iwelogic.coins_presentation.ui.details

import com.iwelogic.coins_presentation.models.CoinDetails

sealed class CoinDetailsState {
    object Loading : CoinDetailsState()
    object Error : CoinDetailsState()
    data class ScreenData(val coinDetails: CoinDetails) : CoinDetailsState()
}

