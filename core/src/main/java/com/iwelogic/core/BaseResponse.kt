package com.iwelogic.core

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseResponse(

    @field:SerializedName("code")
    @Expose
    val code: ErrorCode? = null,

    @field:SerializedName("message")
    @Expose
    val message: String? = null
)
