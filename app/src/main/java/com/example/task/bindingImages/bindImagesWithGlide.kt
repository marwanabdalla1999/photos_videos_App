package com.example.task.bindingImages

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide



    @BindingAdapter("bind:imageUrl")
    fun loadImageWithGlide(view: ImageView, imageUrl: String) {
        Glide.with(view.context).load(imageUrl).into(view)
    }


