package com.task.decadeofmovies.features.movieDetails.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.base.helpers.IPhotoLoadingHelper
import com.task.decadeofmovies.R
import com.task.decadeofmovies.common.helpers.PhotoLoadingHelper
import com.task.decadeofmovies.features.movieDetails.uiModels.Image
import kotlinx.android.synthetic.main.item_image.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class ImageVH(itemView: View): RecyclerView.ViewHolder(itemView), KoinComponent {

    fun bind(imageUrl:String){
        val imageLoadingHelper: IPhotoLoadingHelper by inject()
        with(itemView){
            imageLoadingHelper.loadImage(context,imageUrl,iv_movie_image)
        }

    }
    companion object{
        fun create(parent:ViewGroup): ImageVH{
            return ImageVH(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false))
        }
    }
}