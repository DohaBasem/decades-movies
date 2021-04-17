package com.task.decadeofmovies.common.network.apis

import com.task.decadeofmovies.common.network.response.MoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MoviesApi {
    @GET("/movies")
    fun getAllRemoteMovies(): Single<MoviesResponse>
}