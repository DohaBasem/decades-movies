package com.task.decadeofmovies.common.network.response

data class MovieItemResponse(
    val title: String,
    val year: String,
    val cast: List<String>,
    val genres: List<String>,
    val rating: Int
){
    companion object{
        fun createForTesting():MovieItemResponse{
            return MovieItemResponse(title = "title",year = "year",cast = listOf(),genres = listOf(),rating = 5)
        }
    }
}