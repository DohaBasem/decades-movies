package com.task.decadeofmovies.features.searchMovies.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.task.decadeofmovies.common.utils.adapters.DifferentiableItemDiffUtil
import com.task.decadeofmovies.features.searchMovies.uiModels.MovieYear
import com.task.decadeofmovies.features.searchMovies.view.interfaces.YearItemClickListener
import com.task.decadeofmovies.features.searchMovies.view.viewholders.YearVH


class YearsAdapter(
    private val itemClickListener: YearItemClickListener
) :
    ListAdapter<MovieYear,YearVH>(DifferentiableItemDiffUtil.getInstance()) {

    private var mCurrentlySelectedItemPos = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearVH {
        return YearVH.create(
            parent, itemClickListener
        )
    }

    override fun onBindViewHolder(holder: YearVH, position: Int) {
        holder.bind(currentList[position])
    }

//    override fun getItemCount(): Int {
//        return items.size
//    }

//    fun setItems(list: List<MovieYear>) {
//        this.items.apply {
//            clear()
//            addAll(list)
//        }
//        notifyDataSetChanged()
//    }

    fun selectItem(position: Int) {
        val oldPosition = mCurrentlySelectedItemPos
        if (position != mCurrentlySelectedItemPos) {
            mCurrentlySelectedItemPos = position
            if (oldPosition != -1)
                currentList[oldPosition].isSelected = false
            currentList[mCurrentlySelectedItemPos].isSelected = true
            notifyItemChanged(oldPosition)
            notifyItemChanged(mCurrentlySelectedItemPos)
        }
    }

}