package com.task.decadeofmovies.common.network.apis

import com.task.decadeofmovies.common.network.response.FlickerPhotoResponse
import com.task.decadeofmovies.common.network.response.FlickerRootResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface PhotosApi {
    @GET
    fun getPhotos(@Url url: String): Single<FlickerRootResponse>
}