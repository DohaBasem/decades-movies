package com.task.decadeofmovies.features.movieDetails.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.movieDetails.viewHolders.CastVH

class CastAdapter : ListAdapter<String, CastVH>(object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastVH {
        return CastVH.createVH(parent)
    }

    override fun onBindViewHolder(holder: CastVH, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_cast
    }
}