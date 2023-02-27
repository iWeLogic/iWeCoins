package com.iwelogic.core

import com.google.gson.annotations.SerializedName

class ErrorHolder(
    val text: String?,
    val code: ErrorCode? = ErrorCode.UNKNOWN
) : Exception()

enum class ErrorCode {

    @SerializedName("3033")
    ALREADY_EXISTS,

    @SerializedName("3087")
    NOT_CONFIRMED,

    @SerializedName("3003")
    INVALID_CREDENTIALS,

    @SerializedName("3020")
    UNABLE_TO_FIND_USER,

    UNKNOWN,

    NO_CONNECTION,

    WRONG_EMAIL,

    PASSWORD_IS_TOO_SHORT,

    WRONG_PASSWORD,

    PASSWORD_TWO_DOESNT_MATCH,
}