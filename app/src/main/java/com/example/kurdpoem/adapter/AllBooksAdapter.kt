package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemAllBookBinding
import com.example.kurdpoem.model.AllBooksModel

class AllBooksAdapter(
    var context: Context,
    val data: List<AllBooksModel>,
var IItemClickListener: (view: View , listBook: AllBooksModel)-> Unit):
    RecyclerView.Adapter<AllBooksAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemAllBookBinding): RecyclerView.ViewHolder(binding.root) {

        fun setDataAllBook(data: AllBooksModel){

            binding.myAllBooks = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater= LayoutInflater.from(context)
        val binding: ItemAllBookBinding = DataBindingUtil.inflate(inflater, R.layout.item_all_book,parent ,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.setDataAllBook(data[position])
        holder.itemView.setOnClickListener {
            IItemClickListener(holder.binding.root , data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}