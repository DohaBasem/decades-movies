package com.task.decadeofmovies.common.repos

import com.task.decadeofmovies.common.mappers.FlickerPhotoToUrlMapper
import com.task.decadeofmovies.common.network.apis.PhotosApi
import com.task.decadeofmovies.common.repos.interfaces.IPhotoSRepo
import com.task.decadeofmovies.common.utils.general.PhotosUrlComposer
import io.reactivex.rxjava3.core.Single
import java.net.URLDecoder

class PhotosRepo(private val photosApi: PhotosApi) :
    IPhotoSRepo {

    override fun getPhotoForMovie(title: String): Single<List<String>> {
        val url = PhotosUrlComposer.composeUrl(
            movieTitle = title,
            pageNumber = 1,
            pageSize = 10
        )
        val decodedUrl = URLDecoder.decode(url, "UTF-8")
        return photosApi.getPhotos(
            decodedUrl
        ).map {
            it.photos.photo.map {
                FlickerPhotoToUrlMapper.map(it,String::class.java)
            }
        }
    }
}