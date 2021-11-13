package com.example.kurdpoem.model

import androidx.databinding.BindingAdapter
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class NewsBannerModel (val link_img: String) {

    companion object {

        @JvmStatic
        @BindingAdapter("android:loadImage")
        fun loadImage(roundedImageView: RoundedImageView, link_img: String) {
            Picasso.get().load(link_img).into(roundedImageView)

        }
    }
}