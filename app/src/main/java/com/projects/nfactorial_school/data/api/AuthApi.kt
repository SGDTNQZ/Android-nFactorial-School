package com.projects.nfactorial_school.data.api

import com.projects.nfactorial_school.data.model.LoginRequest
import com.projects.nfactorial_school.data.model.LoginResponse
import com.projects.nfactorial_school.data.model.RegistrationRequest
import com.projects.nfactorial_school.data.model.RegistrationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/register")
    suspend fun register(@Body request: RegistrationRequest): RegistrationResponse

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest) : LoginResponse
}