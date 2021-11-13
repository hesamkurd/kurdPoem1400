package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemBookDetailBinding
import com.example.kurdpoem.model.BookDetailModel

class BookDetailAdapter(var context: Context, var data: List<BookDetailModel>): RecyclerView.Adapter<BookDetailAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemBookDetailBinding): RecyclerView.ViewHolder(binding.root) {

        fun setDataBookDetail(data: BookDetailModel){

            binding.myDetailBooks = data
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemBookDetailBinding = DataBindingUtil.inflate(inflater, R.layout.item_book_detail,parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataBookDetail(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}