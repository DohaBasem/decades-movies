package com.task.decadeofmovies.common.di

import com.task.decadeofmovies.common.repos.IMoviesRepo
import com.task.decadeofmovies.common.repos.MoviesRepo
import org.koin.dsl.module

val reposModules = module {
    factory { MoviesRepo(moviesApi = get(), moviesDao = get(), sharedPreferenceHelper = get()) as IMoviesRepo }
}