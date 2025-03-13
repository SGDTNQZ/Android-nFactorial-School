package com.projects.nfactorial_school.data.network

import com.projects.nfactorial_school.data.token.TokenProvider
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val tokenProvider: TokenProvider
) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenProvider.getToken()
        val newRequest = chain.request().newBuilder()
            .header("Authorization", "Bearer  $token")
            .build()
        return chain.proceed(newRequest)
    }
}