package com.projects.nfactorial_school.di

import com.google.gson.Gson
import com.projects.nfactorial_school.data.api.Api
import com.projects.nfactorial_school.data.network.AuthInterceptor
import com.projects.nfactorial_school.data.network.RetrofitAuthorizedInstance
import com.projects.nfactorial_school.data.network.RetrofitUnauthorizedInstance
import com.projects.nfactorial_school.data.repository.AuthRepository
import com.projects.nfactorial_school.data.repository.MainRepository
import com.projects.nfactorial_school.data.repository.ReviewRepository
import com.projects.nfactorial_school.data.repository.ValidateRepository
import com.projects.nfactorial_school.data.token.SharedPrefTokenProvider
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.domain.useCases.CatalogDataUseCase
import com.projects.nfactorial_school.domain.useCases.GetMainDataUseCase
import com.projects.nfactorial_school.domain.useCases.LoginUseCase
import com.projects.nfactorial_school.domain.useCases.ReviewUseCase
import com.projects.nfactorial_school.domain.util.ErrorHandler
import com.projects.nfactorial_school.presentation.catalog.viewmodel.CatalogViewModel
import com.projects.nfactorial_school.presentation.login.viewmodel.LoginViewModel
import com.projects.nfactorial_school.presentation.main.viewmodel.MainViewModel
import com.projects.nfactorial_school.presentation.reviews.viewmodel.ReviewViewModel
import com.projects.nfactorial_school.presentation.registration.viewmodel.RegistrationViewModel
import com.projects.nfactorial_school.presentation.splash.viewmodel.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { Gson() }

    single<TokenProvider> {
        SharedPrefTokenProvider(androidContext())
    }

    single {
        RetrofitUnauthorizedInstance.create(Api::class.java)
    }

    single {
        AuthRepository(
            unauthorizedApi = get(),
            tokenProvider = get()
        )
    }

    single {
        AuthInterceptor(get<TokenProvider>())
    }

    single {
        RetrofitAuthorizedInstance.create(get(), Api::class.java)
    }

    single {
        MainRepository(get())
    }
    single {
        ValidateRepository(get())
    }
    single {
        ReviewRepository(get())
    }

    single {
        ErrorHandler(androidContext())
    }

    single { LoginUseCase(get()) }
    single { GetMainDataUseCase(get()) }
    single { CatalogDataUseCase(get()) }
    single { ReviewUseCase(get()) }

    viewModel {
        LoginViewModel(
            loginUseCase = get(),
            errorHandler = get()
        )
    }
    viewModel {
        RegistrationViewModel(
            authRepository = get(),
            errorHandler = get()
        )
    }
    viewModel {
        SplashViewModel(
            tokenProvider = get(),
            validateRepository = get(),
            errorHandler = get()
        )
    }
    viewModel {
        CatalogViewModel(
            repository = get()
        )
    }
    viewModel {
        MainViewModel(
            mainRepository = get()
        )
    }
    viewModel {
        ReviewViewModel(
            reviewsRepository = get()
        )
    }
}
