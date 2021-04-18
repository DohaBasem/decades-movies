package com.task.decadeofmovies.common.mappers

import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import com.task.decadeofmovies.common.mappers.interfaces.IMapper
import com.task.decadeofmovies.common.network.response.MovieItemResponse

object MoviesResponseMapper :
    IMapper<MovieItemResponse, MovieItemEntity> {

    override fun map(from: MovieItemResponse, to: Class<MovieItemEntity>): MovieItemEntity {
        return MovieItemEntity(
            title = from.title,
            year = from.year, rating = from.rating, cast = from.cast, generes = from.genres
        )
    }


}