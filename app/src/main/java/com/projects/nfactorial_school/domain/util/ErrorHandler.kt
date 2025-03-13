package com.projects.nfactorial_school.domain.util

import android.content.Context
import com.projects.nfactorial_school.R
import retrofit2.HttpException

class ErrorHandler(private val context: Context) {

    fun handle(throwable: Throwable): String {
        return if (throwable is HttpException) {
            when (throwable.code()) {
                400 -> context.getString(R.string.error_bad_request)
                401 -> context.getString(R.string.error_auth)
                403 -> context.getString(R.string.error_forbidden)
                404 -> context.getString(R.string.error_not_found)
                409 -> context.getString(R.string.error_user_exists)
                500 -> context.getString(R.string.error_internal)
                503 -> context.getString(R.string.error_service_unavailable)
                else -> context.getString(R.string.error_server, throwable.code())
            }
        } else {
            throwable.message ?: context.getString(R.string.error_unknown)
        }
    }
}
