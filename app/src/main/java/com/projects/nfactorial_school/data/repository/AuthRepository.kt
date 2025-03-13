package com.projects.nfactorial_school.data.repository

import com.projects.nfactorial_school.data.api.Api
import com.projects.nfactorial_school.data.model.LoginRequest
import com.projects.nfactorial_school.data.model.LoginResponse
import com.projects.nfactorial_school.data.model.RegistrationRequest
import com.projects.nfactorial_school.data.model.RegistrationResponse
import com.projects.nfactorial_school.data.token.TokenProvider

class AuthRepository(
    private val unauthorizedApi: Api,
    private val tokenProvider: TokenProvider
) {

    suspend fun register(login: String, password: String): RegistrationResponse {
        val request = RegistrationRequest(login, password)
        val response = unauthorizedApi.register(request)
        tokenProvider.saveToken(response.token)
        return response
    }

    suspend fun login(login: String, password: String): LoginResponse {
        val request = LoginRequest(login, password)
        val response = unauthorizedApi.login(request)
        tokenProvider.saveToken(response.token)
        return response
    }
}
