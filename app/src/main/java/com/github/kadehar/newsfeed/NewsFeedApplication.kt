package com.github.kadehar.newsfeed

import android.app.Application
import com.github.kadehar.newsfeed.base.di.baseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsFeedApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@NewsFeedApplication)
            modules(baseModule)
        }
    }
}