package com.phanupan.awaretest

import android.app.Application
import com.phanupan.awaretest.di.appModule
import com.phanupan.awaretest.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AnimeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AnimeApplication)
            androidLogger()
            modules(networkModule, appModule)
        }
    }
}