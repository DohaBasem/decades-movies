package com.task.decadeofmovies.common.di

import com.task.decadeofmovies.features.splash.SplashVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { SplashVM(loggingHelper = get(), schedulerHelper = get()) }
}