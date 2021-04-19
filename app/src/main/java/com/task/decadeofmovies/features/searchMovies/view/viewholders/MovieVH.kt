package com.task.decadeofmovies.features.searchMovies.view.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.searchMovies.uiModels.Movie
import com.task.decadeofmovies.features.searchMovies.view.interfaces.MovieItemClickListener
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieVH(itemView: View, private val movieItemClickListener: MovieItemClickListener) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Movie){
        with(itemView){
            tv_rating.text = item.rating.toString()
            tv_movie_title.text = "${item.title} (${item.year})"
            setOnClickListener {
                movieItemClickListener.onMovieClicked(item.id,item.title)
            }
        }
    }

    companion object{
        fun create(parent: ViewGroup, itemClickListener: MovieItemClickListener): MovieVH {
            return MovieVH(
                LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_movie, parent, false), itemClickListener
            )
        }
    }
}