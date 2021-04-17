package com.task.decadeofmovies.common.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface MoviesDao {
    @Insert
    fun saveMoviesLocally(movieEntities: List<MovieItemEntity>): Completable

    @Query("SELECT * FROM  MovieItemEntity ")
    fun getAllMovies(): Single<List<MovieItemEntity>>

    @Query("SELECT * FROM  MovieItemEntity WHERE year =:year")
    fun getMoviesWithFilter(year: String): Single<List<MovieItemEntity>>

    @Query("SELECT DISTINCT year FROM MovieItemEntity ")
    fun getDistinctMoviesYears(): LiveData<List<String>>
}