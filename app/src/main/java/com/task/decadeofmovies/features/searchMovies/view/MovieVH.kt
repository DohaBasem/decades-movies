package com.task.decadeofmovies.features.searchMovies.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.searchMovies.uiModels.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Movie){
        with(itemView){
            tv_rating.text = item.rating.toString()
            tv_movie_title.text = item.title
        }
    }

    companion object{
        fun create(parent: ViewGroup): MovieVH {
            return MovieVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false))
        }
    }
}