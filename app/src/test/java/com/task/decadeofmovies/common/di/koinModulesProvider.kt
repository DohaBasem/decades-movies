package com.task.decadeofmovies.common.di

import org.koin.core.module.Module

fun getKoinTestModules(): List<Module>{
    return listOf(viewModelModules, reposModules,
        helpersModules, networkModules, databaseModule)
}