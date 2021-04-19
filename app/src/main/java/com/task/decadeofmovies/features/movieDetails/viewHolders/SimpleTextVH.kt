package com.task.decadeofmovies.features.movieDetails.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.task.decadeofmovies.R
import kotlinx.android.synthetic.main.item_simple_text.view.*

class SimpleTextVH(itemView: View) : TextVH(itemView) {
    override fun bind(text: String) {
        itemView.tv_text.text = text
    }

    companion object{
        fun createVH(parent: ViewGroup): SimpleTextVH{
            return SimpleTextVH(
                LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_simple_text, parent, false))
        }
    }
}