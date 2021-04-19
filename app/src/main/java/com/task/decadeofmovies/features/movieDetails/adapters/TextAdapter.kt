package com.task.decadeofmovies.features.movieDetails.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.movieDetails.viewHolders.HeaderVH
import com.task.decadeofmovies.features.movieDetails.viewHolders.SimpleTextVH
import com.task.decadeofmovies.features.movieDetails.viewHolders.TextVH

class TextAdapter(private val textType: TextType) :
    ListAdapter<String, TextVH>(object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextVH {
        return when (textType) {
            TextType.HEADER -> {
                HeaderVH.createVH(parent)
            }
            TextType.SIMPLE_TEXT -> {
                SimpleTextVH.createVH(parent)
            }
        }
    }

    override fun onBindViewHolder(holder: TextVH, position: Int) {
        holder.bind(getItem(position))
    }
}

enum class TextType {
    HEADER,
    SIMPLE_TEXT
}