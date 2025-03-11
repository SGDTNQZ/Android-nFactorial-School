package com.projects.nfactorial_school.data.network

import com.projects.nfactorial_school.data.api.AuthApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUnauthorizedInstance {
    private const val BASE_URL = "https://nfactorialappbackend.onrender.com/"

    val api: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }
}