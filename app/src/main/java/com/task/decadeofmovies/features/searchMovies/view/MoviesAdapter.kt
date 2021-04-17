package com.task.decadeofmovies.features.searchMovies.view

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.task.decadeofmovies.common.utils.adapters.DifferentiableItemDiffUtil
import com.task.decadeofmovies.features.searchMovies.uiModels.Movie

class MoviesAdapter : ListAdapter<Movie, MovieVH>(DifferentiableItemDiffUtil.getInstance()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH.create(parent)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.bind(getItem(position))
    }
}