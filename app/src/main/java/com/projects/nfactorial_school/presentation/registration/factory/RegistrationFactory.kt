package com.projects.nfactorial_school.presentation.registration.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.projects.nfactorial_school.data.repository.AuthRepository
import com.projects.nfactorial_school.domain.util.ErrorHandler
import com.projects.nfactorial_school.presentation.registration.viewmodel.RegistrationViewModel

class RegistrationViewModelFactory(
    private val authRepository: AuthRepository,
    private val errorHandler: ErrorHandler
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
            return RegistrationViewModel(authRepository, errorHandler) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
