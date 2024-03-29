package com.iwelogic.coins_presentation.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iwelogic.coins_domain.use_case.CoinsUseCase
import com.iwelogic.coins_presentation.models.Coin
import com.iwelogic.coins_presentation.mapper.toCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val coinsUseCase: CoinsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CoinsState>(CoinsState.Loading)
    val state: StateFlow<CoinsState> = _state

    private val openDetailsChannel = Channel<Coin>(capacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val openDetails = openDetailsChannel.receiveAsFlow()

    init {
        onReload()
    }

    private fun onReload() {
        viewModelScope.launch {
            _state.emit(CoinsState.Loading)
            coinsUseCase.getCoins()
                .onSuccess {
                    _state.emit(CoinsState.ScreenData(it.map { item -> item.toCoin() }))
                }
                .onFailure {
                    _state.emit(CoinsState.Error)
                }
        }
    }

    fun onClickCoin(item: Coin) {
        viewModelScope.launch {
            openDetailsChannel.send(item)
        }
    }
}
