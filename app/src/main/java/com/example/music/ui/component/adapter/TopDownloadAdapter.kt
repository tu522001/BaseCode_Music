package com.example.music.ui.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music.data.dto.modelSong.Song
import com.example.music.databinding.ItemLayoutTopDownloadBinding

class TopDownloadAdapter (var context : Context, var listTopDownload: MutableList<Song>):
    RecyclerView.Adapter<TopDownloadAdapter.TopDownloadHolder>() {
    inner class TopDownloadHolder(val itembinding: ItemLayoutTopDownloadBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun bind(song: Song) {

            itembinding.tvNamSongTopDownLoad.text = song.name.take(8) + if (song.name.length > 8) "..." else ""
            Glide.with(itembinding.root).load(song.image).into(itembinding.imgTopDownLoad)
        }
    }

    fun updateData(data: List<Song>) {
        listTopDownload.clear()
        listTopDownload.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDownloadHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var itemBinding = ItemLayoutTopDownloadBinding.inflate(layoutInflater, parent, false)
        return TopDownloadHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: TopDownloadHolder, position: Int) {
        holder.bind(listTopDownload[position])
    }

    override fun getItemCount(): Int {
        if (listTopDownload.isEmpty()) {
            return 0
        }
        return listTopDownload.size
    }
}