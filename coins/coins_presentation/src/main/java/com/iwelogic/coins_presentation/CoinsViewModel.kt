package com.iwelogic.coins_presentation

import com.iwelogic.coins_domain.use_case.CoinsUseCase
import com.iwelogic.core.base.mvvm.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val coinsUseCase: CoinsUseCase
) : BaseViewModel() {


}
