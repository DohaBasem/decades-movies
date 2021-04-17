package com.task.decadeofmovies.features.searchMovies

import com.task.decadeofmovies.features.searchMovies.uiModels.Movie

sealed class MoviesViewState {
    object Idle: MoviesViewState()
    object Loading : MoviesViewState()
    object LoadedWithEmptyPayLoad : MoviesViewState()
    class LoadedWithPayLoad(val list: List<Movie>) : MoviesViewState()
    object GenericError : MoviesViewState()
}