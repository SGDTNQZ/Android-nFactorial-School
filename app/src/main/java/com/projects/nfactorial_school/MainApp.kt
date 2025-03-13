package com.projects.nfactorial_school

import android.app.Application
import com.projects.nfactorial_school.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApp)
            modules(appModule)
        }
    }

}