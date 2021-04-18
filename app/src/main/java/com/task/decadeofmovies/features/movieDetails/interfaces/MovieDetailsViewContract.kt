package com.task.decadeofmovies.features.movieDetails.interfaces

import com.task.decadeofmovies.features.movieDetails.uiModels.MovieDetails

interface MovieDetailsViewContract {
    fun showLoadingDetails()
    fun showDetails(movieDetails: MovieDetails)
    fun showErrorLoadingDetails()
}