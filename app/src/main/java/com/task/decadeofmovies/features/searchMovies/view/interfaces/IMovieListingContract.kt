package com.task.decadeofmovies.features.searchMovies.view.interfaces

import com.task.decadeofmovies.features.searchMovies.uiModels.Movie

interface MovieListingContract {
    fun showMoviesLoading()
    fun showAllMovies(movies: List<Movie>)
    fun showErrorLoadingMovies()
    fun showNoMoviesAvailable()
}