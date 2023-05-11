package com.example.music.ui.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music.data.dto.modelSong.Genres
import com.example.music.databinding.ItemLayoutGenresBinding

class GenresAdapter(var context: Context, var listGenres: MutableList<Genres>):
    RecyclerView.Adapter<GenresAdapter.GenresHolder>()  {
    inner class GenresHolder (val itembinding: ItemLayoutGenresBinding) : RecyclerView.ViewHolder(itembinding.root){
        fun bind(geres: Genres){
            itembinding.tvGenres.text = geres.name
            Glide.with(itembinding.root).load(geres.thumbnail).into(itembinding.imgGenres)
        }
    }

    fun updateData(data: List<Genres>) {
        listGenres.clear()
        listGenres.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var itemBinding = ItemLayoutGenresBinding.inflate(layoutInflater, parent, false)
        return GenresHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: GenresHolder, position: Int) {
        holder.bind(listGenres[position])
    }

    override fun getItemCount(): Int {
        if (listGenres.isEmpty()) {
            return 0
        }
        return listGenres.size
    }


}