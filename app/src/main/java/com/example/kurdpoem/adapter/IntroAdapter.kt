package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemNewsBannerBinding
import com.example.kurdpoem.model.NewsBannerModel

class NewsBannerAdapter (var context: Context, var data: List<NewsBannerModel>):
    RecyclerView.Adapter<NewsBannerAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemNewsBannerBinding ): RecyclerView.ViewHolder(binding.root) {

        fun setDataNewsBanner(data: NewsBannerModel){

            binding.myImageSlider = data
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemNewsBannerBinding = DataBindingUtil.inflate(inflater, R.layout.item_news_banner , parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataNewsBanner(data[position])
    }

    override fun getItemCount(): Int {
       return data.size
    }
}