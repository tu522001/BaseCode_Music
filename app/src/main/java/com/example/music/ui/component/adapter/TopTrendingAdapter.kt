package com.example.music.ui.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music.data.dto.modelSong.Song
import com.example.music.databinding.ItemLayoutNewReleaseBinding
import com.example.music.databinding.ItemLayoutTopTrendingBinding

class TopTrendingAdapter (var context: Context, var listTopTrending: MutableList<Song>) :
    RecyclerView.Adapter<TopTrendingAdapter.TopTrendingHolder>() {
    inner class TopTrendingHolder(val itembinding: ItemLayoutTopTrendingBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun bind(song: Song) {

            itembinding.tvTopTrending.text = song.name.take(8) + if (song.name.length > 8) "..." else ""
            Glide.with(itembinding.root).load(song.image).into(itembinding.imgTopTrending)
        }
    }

    fun updateData(data: List<Song>) {
        listTopTrending.clear()
        listTopTrending.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTrendingHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var itemBinding = ItemLayoutTopTrendingBinding.inflate(layoutInflater, parent, false)
        return TopTrendingHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: TopTrendingHolder, position: Int) {
        holder.bind(listTopTrending[position])
    }

    override fun getItemCount(): Int {
        if (listTopTrending.isEmpty()) {
            return 0
        }
        return listTopTrending.size
    }
}