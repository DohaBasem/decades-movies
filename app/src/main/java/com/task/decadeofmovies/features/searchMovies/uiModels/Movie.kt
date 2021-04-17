package com.task.decadeofmovies.features.searchMovies.uiModels

import com.task.decadeofmovies.common.utils.adapters.DifferentiableItem

data class Movie(
     val id: Int,
     val title: String,
     val rating: Int,
     val year: String
): DifferentiableItem {
    override fun getUniqueIdentifier(): Any {
        return id
    }

    override fun getContent(): String {
       return toString()
    }
}