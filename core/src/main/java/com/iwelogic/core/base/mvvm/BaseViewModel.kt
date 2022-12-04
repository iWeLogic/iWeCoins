package com.iwelogic.core.base.mvvm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iwelogic.core.utils.SingleLiveEvent
import java.lang.ref.WeakReference

open class BaseViewModel() : ViewModel() {

    var progress: MutableLiveData<Boolean> = MutableLiveData(false)
    var error: MutableLiveData<String> = MutableLiveData("")
    val close: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()

    fun onClickClose() {
        close.invoke(true)
    }

    fun onClickRetry() {
        onReload()
    }

    open fun onReload() {

    }

    fun getBase(): BaseViewModel = this
}