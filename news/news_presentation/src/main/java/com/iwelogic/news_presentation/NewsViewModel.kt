package com.iwelogic.news_presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.iwelogic.core.base.mvvm.BaseViewModel
import com.iwelogic.news_domain.models.News
import com.iwelogic.news_domain.use_case.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : BaseViewModel() {

    private val _news = MutableStateFlow<List<News>?>(null)
    val news: StateFlow<List<News>?> = _news

    init {
        onReload()
    }

    override fun onReload() {
        Log.w("myLog", "onReload: NEWS")
        viewModelScope.launch {
            _progress.emit(true)
            _error.emit(null)
            newsUseCase.getNews()
                .onSuccess {
                    _news.emit(it)
                }
                .onFailure {
                    _error.emit(it.message)
                }
            _progress.emit(false)
        }
    }

    fun onClickCoin(item: News) {

    }
}
