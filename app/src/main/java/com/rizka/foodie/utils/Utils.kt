package com.rizka.foodie.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rizka.foodie.R

object Utils {
    fun ImageView.loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .error(R.color.purple_700)
            .placeholder(R.color.purple_700)
            .into(this)
    }
}