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
import com.example.kurdpoem.databinding.ItemAllPoemBinding
import com.example.kurdpoem.model.AllPoemModel
import com.example.kurdpoem.model.FilterPoemList

class AllPoemAdapter (
    var context: Context,
    var data: ArrayList<AllPoemModel>,
    var IItemClickListener: (view: View, listPoem: AllPoemModel) -> Unit
) :
    RecyclerView.Adapter<AllPoemAdapter.MyViewHolder>(), Filterable {

    val mainList = data
    val searchList = ArrayList<AllPoemModel>(data)

    class MyViewHolder(val binding: ItemAllPoemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setDataAllPoem(data: AllPoemModel) {

            binding.myAllPoem = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemAllPoemBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_all_poem, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataAllPoem(data[position])

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

                val filteredList = ArrayList<AllPoemModel>()

                if (p0?.isBlank()!! or p0.isEmpty()){

                    filteredList.addAll(searchList)
                }else{
                    val filterPattern = p0.toString()
                    searchList.forEach {
                        if (it.name.contains(filterPattern)){
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
                mainList.addAll(p1!!.values as List<AllPoemModel>)
                notifyDataSetChanged()
            }


        }

    }

}
