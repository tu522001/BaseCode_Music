package com.example.music.ui.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music.data.dto.modelSong.Song
import com.example.music.databinding.ItemLayoutNewReleaseBinding

class NewReleaseAdapter(var context: Context, var listNewRelease: MutableList<Song>) :
    RecyclerView.Adapter<NewReleaseAdapter.NewReleaseHolder>() {
    inner class NewReleaseHolder(val itembinding: ItemLayoutNewReleaseBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun bind(song: Song) {


//            itembinding.tvNewRelease.text = song.name

//            itembinding.tvNewRelease.text = song.name
//            itembinding.tvNewRelease.ellipsize = TextUtils.TruncateAt.MARQUEE
//            itembinding.tvNewRelease.isSelected = true
            itembinding.tvNewRelease.text = song.name.take(8) + if (song.name.length > 8) "..." else ""
//

//            itembinding.tvNewRelease.setSingleLine()
//            itembinding.tvNewRelease.marqueeRepeatLimit = -1
//            itembinding.tvNewRelease.ellipsize = TextUtils.TruncateAt.MARQUEE
//            itembinding.tvNewRelease.isSelected = true
//            itembinding.tvNewRelease.text = song.name
//
            Glide.with(itembinding.root).load(song.image).into(itembinding.imgNewRelease)
        }
    }

    fun updateData(data: List<Song>) {
        listNewRelease.clear()
        listNewRelease.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewReleaseHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var itemBinding = ItemLayoutNewReleaseBinding.inflate(layoutInflater, parent, false)
        return NewReleaseHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: NewReleaseHolder, position: Int) {
        holder.bind(listNewRelease[position])
    }

    override fun getItemCount(): Int {
        if (listNewRelease.isEmpty()) {
            return 0
        }
        return listNewRelease.size
    }
}