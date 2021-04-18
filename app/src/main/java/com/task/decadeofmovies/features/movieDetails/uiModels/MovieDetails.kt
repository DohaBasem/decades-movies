package com.task.decadeofmovies.features.movieDetails.uiModels

data class MovieDetails(
    val id: Int,
    val title: String,
    val year: String,
    val rating: Int,
    val cast: List<String>? = emptyList(),
    val generes: List<String>? = emptyList(),
    val photos: List<String>? = emptyList()
)