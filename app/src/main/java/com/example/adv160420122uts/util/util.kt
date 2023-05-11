package com.example.adv160420122uts.util


import android.widget.ImageView
import com.example.adv160420122uts.R
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String?) {
    Picasso.get()
        .load(url)
        .resize(400,400)
        .centerCrop()
        .error(R.drawable.baseline_error_24)
        .into(this)
}