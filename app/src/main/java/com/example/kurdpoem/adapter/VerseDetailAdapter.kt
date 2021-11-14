package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemVerseDetailBinding
import com.example.kurdpoem.model.VerseDetailModel

class VerseDetailAdapter (var context: Context, var data: List<VerseDetailModel>): RecyclerView.Adapter<VerseDetailAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemVerseDetailBinding): RecyclerView.ViewHolder(binding.root) {

        fun setDataVerseDetail(data: VerseDetailModel){

            binding.myVerseDetail = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemVerseDetailBinding = DataBindingUtil.inflate(inflater, R.layout.item_verse_detail , parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataVerseDetail(data[position])
    }

    override fun getItemCount(): Int {
       return data.size
    }
}