package com.task.decadeofmovies.common.mappers

import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import com.task.decadeofmovies.features.movieDetails.uiModels.MovieDetails

object MovieDetailsMapper {
    fun mapToMovieDetails(movieItemEntity: MovieItemEntity, photos: List<String>): MovieDetails {
        return movieItemEntity.run {
            MovieDetails(
                id = id,
                title = title,
                year = year,
                rating = rating,
                cast = cast,
                generes = generes,
                photos = photos
            )
        }
    }
}