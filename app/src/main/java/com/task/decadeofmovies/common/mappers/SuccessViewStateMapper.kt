package com.task.decadeofmovies.common.mappers

import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import com.task.decadeofmovies.common.mappers.interfaces.IMapper
import com.task.decadeofmovies.features.searchMovies.MoviesViewState
import com.task.decadeofmovies.features.searchMovies.uiModels.Movie

object SuccessViewStateMapper:
    IMapper<List<MovieItemEntity>, MoviesViewState> {

    override fun map(from: List<MovieItemEntity>, to: Class<MoviesViewState>): MoviesViewState {
        return if (from.isEmpty()) {
            MoviesViewState.LoadedWithEmptyPayLoad
        } else {
            MoviesViewState.LoadedWithPayLoad(from.map {
                MovieUIModelMapper.map(
                    it,
                    Movie::class.java
                )
            })
        }
    }
}