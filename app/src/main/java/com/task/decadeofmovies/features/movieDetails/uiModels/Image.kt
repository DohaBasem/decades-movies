package com.task.decadeofmovies.features.movieDetails.uiModels

import com.task.decadeofmovies.common.utils.adapters.DifferentiableItem

data class Image(
    val imageUrl: String
) : DifferentiableItem {
    override fun getUniqueIdentifier(): Any {
        return toString()
    }

    override fun getContent(): String {
        return toString()
    }
}