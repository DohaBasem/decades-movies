package com.task.decadeofmovies.features.searchMovies.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class YearsAdapter(private var items: MutableList<String> = mutableListOf()) :
    RecyclerView.Adapter<YearVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearVH {
        return YearVH.create(parent)
    }

    override fun onBindViewHolder(holder: YearVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(list: List<String>){
        this.items.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

}