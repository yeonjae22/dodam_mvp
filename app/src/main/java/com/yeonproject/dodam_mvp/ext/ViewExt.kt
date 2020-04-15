package com.yeonproject.dodam_mvp.ext

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import java.io.File

fun ImageView.glideImageSet(image: String, width: Int, height: Int) {
    Glide.with(context)
        .load(image)
        .override(width, height)
        .centerCrop()
        .into(this)
}

fun ImageView.glideImageSet(image: String) {
    Glide.with(context)
        .load(image)
        .centerCrop()
        .into(this)
}

fun ImageView.glideImageSet(image: Uri, width: Int, height: Int) {
    Glide.with(context)
        .load(image)
        .override(width, height)
        .centerCrop()
        .into(this)
}

fun ImageView.glideImageSet(image: Int, width: Int, height: Int) {
    Glide.with(context)
        .load(image)
        .override(width, height)
        .centerCrop()
        .into(this)
}

fun Context.shortToast(resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_SHORT)
        .show()
}

fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT)
        .show()
}