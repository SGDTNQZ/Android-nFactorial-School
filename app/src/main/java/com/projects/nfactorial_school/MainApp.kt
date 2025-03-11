package com.projects.nfactorial_school

import android.app.Application
import com.projects.nfactorial_school.data.network.RetrofitUnauthorizedInstance
import com.projects.nfactorial_school.data.repository.AuthRepository
import com.projects.nfactorial_school.data.token.SharedPrefTokenProvider
import com.projects.nfactorial_school.data.token.TokenProvider

class MainApp : Application() {
    lateinit var authRepository: AuthRepository
        private set
    lateinit var tokenProvider: TokenProvider
        private set

    override fun onCreate() {
        super.onCreate()

        tokenProvider = SharedPrefTokenProvider(this)
        val unauthorizedApi = RetrofitUnauthorizedInstance.api

        authRepository = AuthRepository(unauthorizedApi, tokenProvider)
    }
}