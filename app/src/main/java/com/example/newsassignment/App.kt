package com.example.newsassignment

import android.app.Application
import android.content.Context
import com.example.newsassignment.di.appModule
import com.example.newsassignment.di.databaseModule
import com.example.newsassignment.di.networkModule
import com.example.newsassignment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val context = this
        appContext = applicationContext
        // di modules
        val moduleList=listOf(appModule, networkModule,databaseModule,viewModelModule)
        startKoin {
            modules(moduleList).androidContext(context)
        }
    }

    companion object {
        @get:Synchronized
        var appContext: Context? = null
            private set
    }

}