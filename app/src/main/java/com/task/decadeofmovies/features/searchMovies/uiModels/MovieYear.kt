package com.task.decadeofmovies.features.searchMovies.uiModels

import com.task.decadeofmovies.common.utils.adapters.DifferentiableItem

data class MovieYear(
    val year: String,
    var isSelected: Boolean = false
): DifferentiableItem {
    override fun getUniqueIdentifier(): Any {
        return year
    }

    override fun getContent(): String {
        return toString()
    }
}