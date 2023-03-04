package com.iwelogic.news_presentation.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iwelogic.news_domain.models.NewsDomain
import com.iwelogic.news_domain.use_case.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<NewsDetailsState>(NewsDetailsState.Loading)
    val state: StateFlow<NewsDetailsState> = _state

    init {
        onReload()
    }

    private fun onReload() {
        _state.value = NewsDetailsState.Loading
        viewModelScope.launch {
            newsUseCase.getNews()
                .onSuccess {
                    _state.value = NewsDetailsState.NewsData(it)
                }
                .onFailure {
                    _state.value = NewsDetailsState.Error
                }

        }
    }

    fun onClickCoin(item: NewsDomain) {

    }
}
