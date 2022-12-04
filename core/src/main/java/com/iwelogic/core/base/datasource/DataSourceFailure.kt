package com.iwelogic.core.base.datasource

import com.iwelogic.core.base.models.ErrorCode

class DataSourceFailure(
    val errorCode: ErrorCode,
    val failureMessage: String?
) : Throwable(failureMessage)