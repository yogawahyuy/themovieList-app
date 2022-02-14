package com.snystudio.themovielist.config

import android.app.Application
import com.snystudio.themovielist.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            //if(BuildConfig.DEBUG)
            androidLogger(Level.ERROR)
            androidContext(this@App)
            fragmentFactory()
        modules(listOf(repoModule, viewModelModule, retrofitModule, apiModule))}
    }
}