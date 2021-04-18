package com.task.decadeofmovies.common.mappers

import com.task.decadeofmovies.common.mappers.interfaces.IMapper
import com.task.decadeofmovies.common.network.response.FlickerPhoto

object FlickerPhotoToUrlMapper:
    IMapper<FlickerPhoto, String> {
    override fun map(from: FlickerPhoto, to: Class<String>): String {
        return "http://farm${from.farm}.static.flickr.com/${from.server}/${from.id}_${from.secret}.jpg"
    }
}