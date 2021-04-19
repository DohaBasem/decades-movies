package com.task.decadeofmovies.features.movieDetails.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.decadeofmovies.R
import kotlinx.android.synthetic.main.item_cast.view.*
import kotlinx.android.synthetic.main.item_genere.view.*

class GenereVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(cast: String){
        itemView.tv_genere.text = cast
    }

    companion object{
        fun createVH(parent: ViewGroup): GenereVH{
            return GenereVH(
                LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_genere, parent, false))
        }
    }
}