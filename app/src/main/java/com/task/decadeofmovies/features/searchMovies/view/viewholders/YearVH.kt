package com.task.decadeofmovies.features.searchMovies.view.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.searchMovies.uiModels.MovieYear
import com.task.decadeofmovies.features.searchMovies.view.interfaces.YearItemClickListener
import kotlinx.android.synthetic.main.item_year.view.*

class YearVH(itemView: View, private val itemClickListener: YearItemClickListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: MovieYear){
        with(itemView){
            tv_year.text = item.year
            tv_year.isSelected = item.isSelected
            if (item.isSelected){
                tv_year.setTextColor(ContextCompat.getColor(context,R.color.white))
            } else{
                tv_year.setTextColor(ContextCompat.getColor(context,R.color.grey_1))
            }
            setOnClickListener {
                tv_year.isSelected = true
                tv_year.setTextColor(ContextCompat.getColor(context,R.color.white))
                itemClickListener.onYearClicked(item.year, adapterPosition)
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup, itemClickListener: YearItemClickListener): YearVH {
            return YearVH(
                LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_year, parent, false),
                itemClickListener
            )
        }
    }
}