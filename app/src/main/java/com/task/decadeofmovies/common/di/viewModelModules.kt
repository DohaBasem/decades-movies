package com.task.decadeofmovies.common.di

import com.task.decadeofmovies.features.movieDetails.MovieDetailsVM
import com.task.decadeofmovies.features.searchMovies.SearchMoviesVM
import com.task.decadeofmovies.features.splash.SplashVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { SplashVM(loggingHelper = get(), schedulerHelper = get()) }
    viewModel { SearchMoviesVM(loggingHelper = get(), schedulerHelpers = get(), moviesRepo = get()) }
    viewModel { MovieDetailsVM(loggingHelper = get(), schedulerHelpers = get(), photosRepo = get(), moviesRepo = get()) }
}