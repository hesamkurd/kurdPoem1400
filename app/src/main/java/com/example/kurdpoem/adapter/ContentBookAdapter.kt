package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemContentBookBinding
import com.example.kurdpoem.model.ContentBookModel

class ContentBookAdapter(
    var context: Context,
    var data: List<ContentBookModel>,
    var IItemClickListener:(view: View, listContent: ContentBookModel )-> Unit):
    RecyclerView.Adapter<ContentBookAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemContentBookBinding): RecyclerView.ViewHolder(binding.root) {

        fun setDataContentBook(data: ContentBookModel){

            binding.myContentBook = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemContentBookBinding = DataBindingUtil.inflate(inflater, R.layout.item_content_book,parent,false)


        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataContentBook(data[position])

        holder.itemView.setOnClickListener {
            IItemClickListener(holder.binding.root , data[position])
        }


    }

    override fun getItemCount(): Int {
       return data.size
    }
}