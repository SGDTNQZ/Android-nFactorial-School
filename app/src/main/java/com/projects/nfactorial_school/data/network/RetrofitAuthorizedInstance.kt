package com.projects.nfactorial_school.data.network

import com.projects.nfactorial_school.data.api.AuthApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAuthorizedInstance {
    private const val BASE_URL = "https://nfactorialappbackend.onrender.com/"

    fun create(authInterceptor: AuthInterceptor): AuthApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }
}
