package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemAllPoemBinding
import com.example.kurdpoem.databinding.ItemNewBooksBinding
import com.example.kurdpoem.model.AllBooksModel

class NewBooksBannerAdapter(
    var context: Context,
    var data: List<AllBooksModel> ,
    var IItemClickListener: (view: View, listBook: AllBooksModel) -> Unit):

    RecyclerView.Adapter<NewBooksBannerAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemNewBooksBinding): RecyclerView.ViewHolder(binding.root) {

        fun setDataNewBook(data: AllBooksModel){

            binding.myNewBook = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemNewBooksBinding = DataBindingUtil.inflate(inflater, R.layout.item_new_books, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataNewBook(data[position])

        holder.itemView.setOnClickListener {
            IItemClickListener(holder.binding.root, data[position])

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}