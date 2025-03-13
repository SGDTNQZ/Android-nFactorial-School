package com.projects.nfactorial_school.domain.useCases

import com.projects.nfactorial_school.data.repository.MainRepository

class GetMainDataUseCase(private val mainRepository: MainRepository) {
    suspend operator fun invoke() = mainRepository.getMainData()
}
