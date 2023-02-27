package com.iwelogic.core

import com.google.gson.Gson
import retrofit2.Response

open class BaseDataSource {

    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun <T> getResponse(request: suspend () -> Response<T>): Result<T?> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                Result.success(result.body())
            } else {
                return try {
                    val responseError = Gson().fromJson(result.errorBody()?.string(), BaseResponse::class.java)
                    Result.failure<T>(ErrorHolder(responseError.message))
                } catch (e: Exception) {
                    Result.failure<T>(ErrorHolder(e.message))
                }
            }
        } catch (e: Throwable) {
            Result.failure<T>(ErrorHolder(e.message))
        }
    }
}