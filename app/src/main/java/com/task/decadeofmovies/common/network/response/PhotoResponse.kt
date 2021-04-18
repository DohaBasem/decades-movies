package com.task.decadeofmovies.common.network.response

data class FlickerRootResponse(
    val photos: FlickerPhotoResponse
)

data class FlickerPhotoResponse(
    val photo: List<FlickerPhoto>
)

data class FlickerPhoto(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: String,
    val title: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int
)