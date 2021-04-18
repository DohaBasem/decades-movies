package com.task.base.helpers

import android.content.Context
import android.widget.ImageView

interface IPhotoLoadingHelper {
    fun loadImage(context: Context, imageUrl: String?, imageView: ImageView)
}