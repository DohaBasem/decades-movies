package com.task.decadeofmovies.common.di

import com.task.decadeofmovies.common.repos.interfaces.IMoviesRepo
import com.task.decadeofmovies.common.repos.interfaces.IPhotoSRepo
import com.task.decadeofmovies.common.repos.MoviesRepo
import com.task.decadeofmovies.common.repos.PhotosRepo
import org.koin.dsl.module

val reposModules = module {
    factory { MoviesRepo(moviesApi = get(), moviesDao = get(), sharedPreferenceHelper = get()) as IMoviesRepo }
    factory { PhotosRepo(photosApi = get()) as IPhotoSRepo }
}