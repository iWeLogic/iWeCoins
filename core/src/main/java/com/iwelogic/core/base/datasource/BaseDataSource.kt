package com.iwelogic.core.base.datasource

import com.google.gson.Gson
import com.iwelogic.core.base.models.BaseResponse
import com.iwelogic.core.base.models.ErrorCode
import retrofit2.Response
import java.net.UnknownHostException

open class BaseDataSource {

    suspend fun <T> getResponse(request: suspend () -> Response<T>): Result<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                if (result.body() is BaseResponse && (result.body() as BaseResponse).success != true) {
                    val dataSourceFailure = DataSourceFailure(
                        errorCode = (result.body() as BaseResponse).code!!,
                        failureMessage = (result.body() as BaseResponse).message
                    )
                    Result.failure(dataSourceFailure)
                } else {
                    Result.success(result.body()!!)
                }
            } else {
                return try {
                    val responseError = Gson().fromJson(result.errorBody()?.string(), BaseResponse::class.java)
                    val dataSourceFailure = DataSourceFailure(
                        errorCode = responseError.code!!,
                        failureMessage = responseError.message
                    )
                    Result.failure(dataSourceFailure)
                } catch (e: Exception) {
                    val dataSourceFailure = DataSourceFailure(
                        errorCode = ErrorCode.UNKNOWN,
                        failureMessage = e.message
                    )
                    Result.failure(dataSourceFailure)
                }
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            when (e) {
                is UnknownHostException -> {
                    val dataSourceFailure = DataSourceFailure(
                        errorCode = ErrorCode.UNKNOWN,
                        failureMessage = e.message
                    )
                    Result.failure(dataSourceFailure)
                }
                else -> {
                    val dataSourceFailure = DataSourceFailure(
                        errorCode = ErrorCode.UNKNOWN,
                        failureMessage = e.message
                    )
                    Result.failure(dataSourceFailure)
                }
            }
        }
    }
}

