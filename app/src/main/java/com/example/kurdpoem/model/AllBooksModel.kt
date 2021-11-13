package com.example.kurdpoem.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class AllBooksModel(
    val id: String,
    val name: String,
    val poem: String,
    val link_img: String,
    val id_poem: String,
    val new: String) {

    companion object{

        @JvmStatic
        @BindingAdapter("android:loadImageBooks")
        fun loadImageBooks(imageView: ImageView , link_img: String){
            Picasso.get().load(link_img).into(imageView)
        }

    }


}