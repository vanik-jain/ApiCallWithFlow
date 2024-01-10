package com.example.hopscotch

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions

/**
 * Created by vanikjain on 31/10/23
 */

fun loadImage(imageUrl: String, imageView: ImageView) {
  val options = RequestOptions().dontTransform().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
  Glide.with(imageView.context).load(GlideUrl(imageUrl)).apply(options).into(imageView)
}