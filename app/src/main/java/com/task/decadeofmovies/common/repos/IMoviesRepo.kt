package com.task.decadeofmovies.common.repos

import androidx.lifecycle.LiveData
import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import io.reactivex.rxjava3.core.Single

interface IMoviesRepo{
    fun fetchAllMovies(): Single<List<MovieItemEntity>>
    fun filterMovies(year: String): Single<List<MovieItemEntity>>
    fun fetchMoviesDistinctYears(): LiveData<List<String>>
}