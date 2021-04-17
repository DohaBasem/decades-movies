package com.task.decadeofmovies.common.repos

import androidx.lifecycle.LiveData
import com.task.base.helpers.ISharedPreferenceHelper
import com.task.decadeofmovies.common.db.dao.MoviesDao
import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import com.task.decadeofmovies.common.mappers.MoviesResponseMapper
import com.task.decadeofmovies.common.network.response.MoviesResponse
import com.task.decadeofmovies.common.network.apis.MoviesApi
import com.task.decadeofmovies.common.network.response.MovieItemResponse
import io.reactivex.rxjava3.core.Single

class MoviesRepo(
    private val moviesApi: MoviesApi,
    private val moviesDao: MoviesDao,
    private val sharedPreferenceHelper: ISharedPreferenceHelper
): IMoviesRepo {

    /*The source for the movies listing will be always the local db, so if the db is empty because
     the list has not been fetched remotely before, then it is fetched remotely first and saved to db
     after this is successfull, the flag for checking if there has been a local call is marked to true
     then the items are fetched from the local db
    * */
    override fun fetchAllMovies(): Single<List<MovieItemEntity>> {
        val isFirsTimeLoading = sharedPreferenceHelper.getBoolean(MOVIES_FIRST_TIME_LOADING, true)
        return if (isFirsTimeLoading) {
            //Load from network
            //save to db
            //set first time loading to false upon success
            moviesApi.getAllRemoteMovies().flatMap {
                val list = it.movies.map {
                    val entity = MoviesResponseMapper.map(it, MovieItemEntity::class.java)
                    return@map entity
                }
                moviesDao.saveMoviesLocally(list).doOnComplete {
                    sharedPreferenceHelper.saveBoolean(MOVIES_FIRST_TIME_LOADING,false)
                }.andThen(
                    moviesDao.getAllMovies()
                )
            }
        } else {
            //Load from db
            moviesDao.getAllMovies()
        }

    }

    override fun filterMovies(year: String): Single<List<MovieItemEntity>> {
        return moviesDao.getMoviesWithFilter(year)
    }

    override fun fetchMoviesDistinctYears():LiveData<List<String>> = moviesDao.getDistinctMoviesYears()

    companion object {
        const val MOVIES_FIRST_TIME_LOADING = "movies_first_time_loading"
    }
}