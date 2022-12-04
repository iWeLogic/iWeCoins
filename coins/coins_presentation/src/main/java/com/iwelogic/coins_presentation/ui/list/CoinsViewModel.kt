package com.iwelogic.coins_presentation.ui.list

import androidx.lifecycle.viewModelScope
import com.iwelogic.coins_domain.use_case.CoinsUseCase
import com.iwelogic.coins_presentation.models.Coin
import com.iwelogic.coins_presentation.toCoin
import com.iwelogic.core.base.mvvm.BaseViewModel
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
) : BaseViewModel() {

    private val _coins = MutableStateFlow<List<Coin>?>(null)
    val coins: StateFlow<List<Coin>?> = _coins

    private val openDetailsChannel = Channel<Coin>(capacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val openDetails = openDetailsChannel.receiveAsFlow()

    init {
        onReload()
    }

    override fun onReload() {
        viewModelScope.launch {
            _progress.emit(true)
            _error.emit(null)
            coinsUseCase.getCoins()
                .onSuccess {
                    _coins.emit(it.map { item -> item.toCoin() })
                }
                .onFailure {
                    _error.emit(it.message)
                }
            _progress.emit(false)
        }
    }

    fun onClickCoin(item: Coin) {
        viewModelScope.launch {
            openDetailsChannel.send(item)
        }
    }
}
