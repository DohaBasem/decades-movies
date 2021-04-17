package com.task.decadeofmovies.common.di

import org.koin.core.module.Module

fun getKoinModules(): List<Module>{
    return listOf(viewModelModules, reposModules, helpersModules, networkModules, databaseModule)
}