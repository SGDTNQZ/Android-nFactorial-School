package com.projects.nfactorial_school.data.api

import com.projects.nfactorial_school.data.model.CatalogResponse
import com.projects.nfactorial_school.data.model.LoginRequest
import com.projects.nfactorial_school.data.model.LoginResponse
import com.projects.nfactorial_school.data.model.MainResponse
import com.projects.nfactorial_school.data.model.RegistrationRequest
import com.projects.nfactorial_school.data.model.RegistrationResponse
import com.projects.nfactorial_school.data.model.ReviewResponse
import com.projects.nfactorial_school.data.model.ValidateResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("auth/register")
    suspend fun register(@Body request: RegistrationRequest): RegistrationResponse

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("main")
    suspend fun getMainData(): MainResponse
    @GET("auth/validate")
    suspend fun validateToken(): ValidateResponse

    @GET("catalog")
    suspend fun getCatalogData(): CatalogResponse

    @GET("feedback")
    suspend fun getReview(): ReviewResponse
}
