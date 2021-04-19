package com.task.decadeofmovies.features.movieDetails.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.movieDetails.viewHolders.ImageVH


class ImagesAdapter :
    ListAdapter<String, ImageVH>(object :DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        return ImageVH.create(parent)
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_image
    }
}