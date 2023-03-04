package com.iwelogic.coins_presentation.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iwelogic.coins_domain.use_case.CoinDetailsUseCase
import com.iwelogic.coins_presentation.mapper.toCoinDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsDetailsViewModel @Inject constructor(
    private val useCase: CoinDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CoinDetailsState>(CoinDetailsState.Loading)
    val state: StateFlow<CoinDetailsState> = _state

    init {
        onReload()
    }

    private fun onReload() {
        viewModelScope.launch {
            _state.emit(CoinDetailsState.Loading)
            useCase.getCoinDetails()
                .onSuccess {
                    Log.w("myLog", "onReload S: ${it.history?.data?.size}")
                    _state.emit(CoinDetailsState.ScreenData(it.toCoinDetails()))
                }
                .onFailure {
                    Log.w("myLog", "CoinsDetailsViewModel_onReload: ${it.message}")
                    _state.emit(CoinDetailsState.Error)
                }
        }
    }
}
