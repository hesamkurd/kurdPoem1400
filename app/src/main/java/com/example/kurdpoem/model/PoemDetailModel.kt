package com.example.kurdpoem.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class PoemDetailModel(
    val id: String,
    val name: String,
    val surname: String,
    val birth: String,
    val death: String,
    val link_img: String,
    val more: String,
    val id_poem: String,
    var expandable: Boolean = false) {

    companion object{

        @JvmStatic
        @BindingAdapter("android:loadImagePoem")
        fun loadImagePoem(roundedImageView: RoundedImageView , link_img: String){

            Picasso.get().load(link_img).into(roundedImageView)
        }
    }
}