package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemVerseBinding
import com.example.kurdpoem.model.VerseModel

class VerseAdapter(var context: Context, var data: List<VerseModel>): RecyclerView.Adapter<VerseAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemVerseBinding): RecyclerView.ViewHolder(binding.root) {

        fun setDataVerse(data: VerseModel){

            binding.myVerse = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemVerseBinding = DataBindingUtil.inflate(inflater, R.layout.item_verse,parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataVerse(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}