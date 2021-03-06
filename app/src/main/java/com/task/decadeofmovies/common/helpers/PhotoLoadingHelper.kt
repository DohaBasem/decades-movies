package com.task.decadeofmovies.common.helpers

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.task.base.helpers.IPhotoLoadingHelper

class PhotoLoadingHelper: IPhotoLoadingHelper {
    override fun loadImage(context: Context, imageUrl: String?, imageView: ImageView){
        Glide.with(context).load(imageUrl).into(imageView)
    }
}