package com.blu.testcase.appUtilities.base

import android.app.Application
import com.blu.testcase.appUtilities.base.koinDi.repositoryModule
import com.blu.testcase.appUtilities.base.koinDi.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Mostafa Shiri.
 */
class BluTestCaseApplication:Application(){

    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    private fun configureKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BluTestCaseApplication)
            modules(listOf(viewModelModule, repositoryModule))
        }
    }
}