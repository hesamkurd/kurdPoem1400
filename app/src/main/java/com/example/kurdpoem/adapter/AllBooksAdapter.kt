package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemAllBookBinding
import com.example.kurdpoem.model.AllBooksModel

class AllBooksAdapter(
    var context: Context,
    val data: ArrayList<AllBooksModel>,
    var IItemClickListener: (view: View, listBook: AllBooksModel) -> Unit
) :
    RecyclerView.Adapter<AllBooksAdapter.MyViewHolder>() , Filterable {

    val mainList = data
    val searchList = ArrayList<AllBooksModel>(data)

    class MyViewHolder(val binding: ItemAllBookBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setDataAllBook(data: AllBooksModel) {

            binding.myAllBooks = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemAllBookBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_all_book, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataAllBook(data[position])
        holder.itemView.setOnClickListener {
            IItemClickListener(holder.binding.root, data[position])
            
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {

                val filteredList = ArrayList<AllBooksModel>()

                if (p0?.isBlank()!! or p0.isEmpty()){
                    filteredList.addAll(searchList)
                }else{

                    val filteredPattern = p0.toString()
                    searchList.forEach {
                        if (it.name.contains(filteredPattern) || it.poem.contains(filteredPattern)){
                            filteredList.add(it)
                        }
                    }
                }
                val result = FilterResults()
                result.values = filteredList

                return result
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                mainList.clear()
                mainList.addAll(p1?.values as List<AllBooksModel>)
                notifyDataSetChanged()
            }


        }
    }
}