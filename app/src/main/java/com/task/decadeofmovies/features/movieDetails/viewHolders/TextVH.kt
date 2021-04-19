package com.task.decadeofmovies.features.movieDetails.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class TextVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(text: String)
}