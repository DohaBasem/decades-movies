package com.task.decadeofmovies.features.movieDetails.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.decadeofmovies.R
import kotlinx.android.synthetic.main.item_cast.view.*

class CastVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(cast: String){
        itemView.tv_cast.text = cast
    }

    companion object{
        fun createVH(parent: ViewGroup): CastVH{
            return CastVH(
                LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cast, parent, false))
        }
    }
}