package com.iwelogic.news_presentation.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iwelogic.news_domain.models.News
import com.iwelogic.news_domain.use_case.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<NewsState>(NewsState.Loading)
    val state: StateFlow<NewsState> = _state

    private val _event = Channel<NewsEvent>(capacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val event = _event.receiveAsFlow()

    init {
        onReload()
    }

    private fun onReload() {
        _state.value = NewsState.Loading
        viewModelScope.launch {
            newsUseCase.getNews()
                .onSuccess {
                    _state.value = NewsState.NewsData(it)
                }
                .onFailure {
                    _state.value = NewsState.Error
                }

        }
    }

    fun onClickNews(item: News) {
        viewModelScope.launch {
            _event.send(NewsEvent.OpenNewsDetails(item))
        }
    }
}
