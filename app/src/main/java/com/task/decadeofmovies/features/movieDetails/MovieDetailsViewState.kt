package com.task.decadeofmovies.features.movieDetails

import com.task.decadeofmovies.features.movieDetails.uiModels.MovieDetails

sealed class MovieDetailsViewState {
    object Idle: MovieDetailsViewState()
    object Loading: MovieDetailsViewState()
    class SuccessState(val movieDetails: MovieDetails) : MovieDetailsViewState()
    object ErrorState : MovieDetailsViewState()
}