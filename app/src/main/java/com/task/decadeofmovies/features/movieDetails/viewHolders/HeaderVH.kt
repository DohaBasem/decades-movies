package com.task.decadeofmovies.features.movieDetails.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.task.decadeofmovies.R

class HeaderVH(itemView: View) : TextVH(itemView) {
    override fun bind(text: String) {
    }
    companion object{
        fun createVH(parent: ViewGroup): HeaderVH{
            return HeaderVH(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_header, parent, false))
        }
    }
}