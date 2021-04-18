package com.task.decadeofmovies.features.searchMovies.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.task.decadeofmovies.common.utils.adapters.DifferentiableItemDiffUtil
import com.task.decadeofmovies.features.searchMovies.uiModels.Movie
import com.task.decadeofmovies.features.searchMovies.view.viewholders.MovieVH
import com.task.decadeofmovies.features.searchMovies.view.interfaces.MovieItemClickListener

class MoviesAdapter(private val clickListener: MovieItemClickListener) : ListAdapter<Movie, MovieVH>(DifferentiableItemDiffUtil.getInstance()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH.create(
            parent,
            clickListener
        )
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.bind(getItem(position))
    }
}