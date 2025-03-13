package com.projects.nfactorial_school.data.repository

import com.projects.nfactorial_school.data.api.Api
import com.projects.nfactorial_school.data.model.ValidateResponse

class ValidateRepository(
    private val authorizedApi: Api
) {
    suspend fun validateToken(): ValidateResponse {
        return authorizedApi.validateToken()
    }
}
