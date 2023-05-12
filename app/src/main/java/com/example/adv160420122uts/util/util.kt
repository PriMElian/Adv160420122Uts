package com.example.adv160420122uts.util


import android.widget.ImageView
import androidx.databinding.BindingAdapter
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

@BindingAdapter("android:imageUrl")
fun loadPhotoURL(view: ImageView, url: String) {
    view.loadImage(url)
}