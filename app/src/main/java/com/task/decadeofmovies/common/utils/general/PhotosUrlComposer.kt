package com.task.decadeofmovies.common.utils.general

object PhotosUrlComposer {
    fun composeUrl(movieTitle:String,pageNumber:Int,pageSize:Int):String{
        return "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=${FLICKER_API_KEY}&format=json&nojsoncallback=1&text=${movieTitle}&page=${pageNumber}&per_page=${pageSize}"
    }

    const val FLICKER_API_KEY = "18ed779e06fe04c8300d4f2f449ba359" //This might not be the best place to add the API keys
}