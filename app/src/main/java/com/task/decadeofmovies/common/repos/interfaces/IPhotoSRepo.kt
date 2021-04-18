package com.task.decadeofmovies.common.repos.interfaces

import com.task.decadeofmovies.common.network.response.FlickerPhotoResponse
import com.task.decadeofmovies.common.network.response.FlickerRootResponse
import io.reactivex.rxjava3.core.Single

interface IPhotoSRepo {
    fun getPhotoForMovie(title: String): Single<List<String>>
}