package com.iwelogic.core.views

import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class SwipeRefreshLayoutWithoutIndicator : SwipeRefreshLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    override fun setOnRefreshListener(listener: OnRefreshListener?) {
        super.setOnRefreshListener {
            listener?.onRefresh()
            isRefreshing = false
        }
    }
}