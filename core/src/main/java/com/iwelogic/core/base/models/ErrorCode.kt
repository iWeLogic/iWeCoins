package com.iwelogic.core.base.models

import com.google.gson.annotations.SerializedName

enum class ErrorCode {

    UNKNOWN,

    NO_CONNECTION,

    @SerializedName("account_exsits")
    ACCOUNT_EXISTS,

    @SerializedName("authentification_failed")
    AUTHENTIFICATION_FAILED,

    @SerializedName("account_not_found")
    ACCOUNT_NOT_FOUND,
}