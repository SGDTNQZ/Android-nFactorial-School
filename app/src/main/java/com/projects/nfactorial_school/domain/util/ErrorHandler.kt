package com.projects.nfactorial_school.domain.util

import android.content.Context
import com.projects.nfactorial_school.R
import retrofit2.HttpException

class ErrorHandler(private val context: Context) {

    fun handle(throwable: Throwable): String {
        return if (throwable is HttpException) {
            when (throwable.code()) {
                401 -> context.getString(R.string.error_auth)
                409 -> context.getString(R.string.error_user_exists)
                else -> context.getString(R.string.error_server, throwable.code())
            }
        } else {
            throwable.message ?: context.getString(R.string.error_unknown)
        }
    }
}
