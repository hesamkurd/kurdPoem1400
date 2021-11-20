package com.example.kurdpoem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.ItemVerseFavoriteBinding
import com.example.kurdpoem.model.FavoriteListModel

class FavoriteListAdapter(
    var context: Context,
    var data: ArrayList<FavoriteListModel>,
    var IItemClickListener: (view: View, listFavorite: FavoriteListModel)->Unit , var deleteFavorite: DeleteFavorite ): RecyclerView.Adapter<FavoriteListAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemVerseFavoriteBinding): RecyclerView.ViewHolder(binding.root) {



        fun setDataVerse(data: FavoriteListModel){

            binding.myVerseDetail = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemVerseFavoriteBinding = DataBindingUtil.inflate(inflater, R.layout.item_verse_favorite,parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setDataVerse(data[position])

        holder.itemView.setOnClickListener {
            IItemClickListener(holder.binding.root , data[position])

        }

        holder.binding.imgDelete.setOnClickListener {
            deleteFavorite.IItemDelete(data[position])
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }

   interface DeleteFavorite{
       fun IItemDelete(favoriteListModel: FavoriteListModel)
   }

    fun deleteIndex(favoriteListModel: FavoriteListModel){

        val index:Int = data.indexOf(favoriteListModel)
        data.removeAt(index)
        notifyDataSetChanged()

    }







}