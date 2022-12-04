package com.iwelogic.core.base.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel() : ViewModel() {

    protected val _progress = MutableStateFlow(false)
    val progress: StateFlow<Boolean> = _progress

    protected val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val toastChannel = Channel<String>(capacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val toast = toastChannel.receiveAsFlow()

    private val closeChannel = Channel<Boolean>(capacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val close = closeChannel.receiveAsFlow()

    fun onClickClose() {
        viewModelScope.launch {
            closeChannel.send(true)
        }
    }

    fun showToast(message: String) {
        viewModelScope.launch {
            toastChannel.send(message)
        }
    }

    open fun onReload() {

    }
}