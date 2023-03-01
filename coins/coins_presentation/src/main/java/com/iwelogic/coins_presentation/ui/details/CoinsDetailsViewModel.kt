package com.iwelogic.coins_presentation.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iwelogic.coins_domain.use_case.CoinsUseCase
import com.iwelogic.coins_presentation.models.Coin
import com.iwelogic.coins_presentation.toCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsDetailsViewModel @Inject constructor(
    private val coinsUseCase: CoinsUseCase
) : ViewModel() {


}
