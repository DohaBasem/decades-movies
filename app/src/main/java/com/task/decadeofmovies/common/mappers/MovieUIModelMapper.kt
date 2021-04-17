package com.task.decadeofmovies.common.mappers

import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import com.task.decadeofmovies.features.searchMovies.uiModels.Movie

object MovieUIModelMapper : IMapper<MovieItemEntity, Movie> {

    override fun map(from: MovieItemEntity, to: Class<Movie>): Movie {
        return Movie(id = from.id, title = from.title, rating = from.rating, year = from.year)
    }
}