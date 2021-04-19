package com.task.decadeofmovies.features.movieDetails.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.movieDetails.viewHolders.GenereVH

class GenereAdapter : ListAdapter<String, GenereVH>(object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenereVH {
        return GenereVH.createVH(parent)
    }

    override fun onBindViewHolder(holder: GenereVH, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_genere
    }
}