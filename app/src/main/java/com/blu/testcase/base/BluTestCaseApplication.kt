package com.blu.testcase.base

import android.app.Application
import com.blu.testcase.base.koinDi.repositoryModule
import com.blu.testcase.base.koinDi.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module

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