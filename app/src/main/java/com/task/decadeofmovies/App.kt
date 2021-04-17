package com.task.decadeofmovies

import android.app.Application
import com.task.decadeofmovies.common.di.getKoinModules
import com.task.decadeofmovies.common.di.helpersModules
import com.task.decadeofmovies.common.di.reposModules
import com.task.decadeofmovies.common.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(getKoinModules())
        }
    }


}