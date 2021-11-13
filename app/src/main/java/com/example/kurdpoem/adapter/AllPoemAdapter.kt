package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemAllPoemBinding
import com.example.kurdpoem.model.AllPoemModel

class AllPoemAdapter (var context: Context, var data: List<AllPoemModel>):
    RecyclerView.Adapter<AllPoemAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemAllPoemBinding): RecyclerView.ViewHolder(binding.root) {

        fun setDataAllPoem(data : AllPoemModel){

            binding.myAllPoem = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemAllPoemBinding = DataBindingUtil.inflate(inflater, R.layout.item_all_poem, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataAllPoem(data[position])
    }

    override fun getItemCount(): Int {
       return data.size
    }
}