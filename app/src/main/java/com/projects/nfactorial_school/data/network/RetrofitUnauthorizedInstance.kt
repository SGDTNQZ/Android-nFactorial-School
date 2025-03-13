package com.projects.nfactorial_school.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUnauthorizedInstance {
    private const val BASE_URL = "https://nfactorialappbackend.onrender.com/"

    fun <T> create(service: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(service)
    }
}
