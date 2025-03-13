package com.projects.nfactorial_school.domain.useCases

import com.projects.nfactorial_school.data.model.CatalogResponse
import com.projects.nfactorial_school.data.repository.MainRepository

class CatalogDataUseCase(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke() : CatalogResponse{
        return mainRepository.getCatalogData()
    }
}