package com.projects.nfactorial_school.presentation.registration.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.projects.nfactorial_school.data.repository.AuthRepository
import com.projects.nfactorial_school.presentation.registration.viewmodel.RegistrationViewModel

class RegistrationViewModelFactory(
    private val authRepository: AuthRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
            return RegistrationViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
