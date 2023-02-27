package com.iwelogic.coins_presentation.ui.list

import com.iwelogic.coins_presentation.models.Coin

sealed class CoinsUiState {
    object Loading : CoinsUiState()
    object Error : CoinsUiState()
    data class ScreenData(val coins: List<Coin>) : CoinsUiState()
}

