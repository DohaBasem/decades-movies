package com.task.decadeofmovies.features.searchMovies.view.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.decadeofmovies.R
import kotlinx.android.synthetic.main.item_year.view.*

class YearVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: String){
        with(itemView){
            tv_year.text = item
        }
    }

    companion object {
        fun create(parent: ViewGroup): YearVH {
            return YearVH(
                LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_year, parent, false)
            )
        }
    }
}