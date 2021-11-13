package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemPoemDetailBinding
import com.example.kurdpoem.model.PoemDetailModel

class PoemDetailAdapter(var context: Context ,var data: List<PoemDetailModel>):
    RecyclerView.Adapter<PoemDetailAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemPoemDetailBinding): RecyclerView.ViewHolder(binding.root) {

        fun setDataPoemDetail(data: PoemDetailModel){

            binding.myPoemDetail = data
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemPoemDetailBinding = DataBindingUtil.inflate(inflater, R.layout.item_poem_detail, parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataPoemDetail(data[position])

        val isExpandable : Boolean = data[position].expandable
        holder.binding.expandable.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.binding.linearLayout.setOnClickListener {
            val data_ = data[position]
            data_.expandable = !data_.expandable
            notifyItemChanged(position)

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}