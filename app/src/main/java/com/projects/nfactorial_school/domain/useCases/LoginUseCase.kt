package com.projects.nfactorial_school.domain.useCases

import com.projects.nfactorial_school.data.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(login: String, password: String) = authRepository.login(login,password)
}