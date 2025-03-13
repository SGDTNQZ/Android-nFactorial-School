package com.projects.nfactorial_school.data.repository

import com.projects.nfactorial_school.data.api.Api
import com.projects.nfactorial_school.data.model.CatalogResponse
import com.projects.nfactorial_school.data.model.MainResponse

class MainRepository(
    private val authorizedApi: Api
) {
    suspend fun getMainData(): MainResponse = authorizedApi.getMainData()
    suspend fun getCatalogData(): CatalogResponse = authorizedApi.getCatalogData()
}
