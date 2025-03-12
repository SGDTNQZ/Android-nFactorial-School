package com.projects.nfactorial_school

import android.app.Application
import com.projects.nfactorial_school.data.api.Api
import com.projects.nfactorial_school.data.network.AuthInterceptor
import com.projects.nfactorial_school.data.network.RetrofitAuthorizedInstance
import com.projects.nfactorial_school.data.network.RetrofitUnauthorizedInstance
import com.projects.nfactorial_school.data.repository.AuthRepository
import com.projects.nfactorial_school.data.repository.MainRepository
import com.projects.nfactorial_school.data.token.SharedPrefTokenProvider
import com.projects.nfactorial_school.data.token.TokenProvider

class MainApp : Application() {
    lateinit var authRepository: AuthRepository
        private set
    lateinit var tokenProvider: TokenProvider
        private set
    lateinit var mainRepository: MainRepository
        private set

    override fun onCreate() {
        super.onCreate()

        tokenProvider = SharedPrefTokenProvider(this)
        val unauthorizedApi = RetrofitUnauthorizedInstance.create(Api::class.java)
        authRepository = AuthRepository(unauthorizedApi, tokenProvider)
        val authInterceptor = AuthInterceptor(tokenProvider)
        val authorizedApi = RetrofitAuthorizedInstance.create(authInterceptor, Api::class.java)
        mainRepository = MainRepository(authorizedApi)
    }
}