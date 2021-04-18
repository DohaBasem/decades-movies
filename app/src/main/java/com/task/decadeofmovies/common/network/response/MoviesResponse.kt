package com.task.decadeofmovies.common.network.response

data class MoviesResponse(
   val movies: List<MovieItemResponse>
){
   companion object{
      fun createForTesting(): MoviesResponse{
         return MoviesResponse(listOf(MovieItemResponse.createForTesting()))
      }
   }
}