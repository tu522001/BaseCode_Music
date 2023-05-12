package com.example.music.ui.component.adapter

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music.data.dto.modelSong.Song
import com.example.music.databinding.ItemLayoutNewReleaseBinding
import com.example.music.ui.base.listeners.onClickItemListener

class NewReleaseAdapter(
    var context: Context,
    var onClickItemListener: onClickItemListener,
    var listNewRelease: MutableList<Song>
) :
    RecyclerView.Adapter<NewReleaseAdapter.NewReleaseHolder>() {
    private var mediaPlayer: MediaPlayer? = null

    inner class NewReleaseHolder(val itembinding: ItemLayoutNewReleaseBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun bind(song: Song) {

            itembinding.tvNewRelease.text =
                song.name.take(8) + if (song.name.length > 8) "..." else ""
            Glide.with(itembinding.root).load(song.image).into(itembinding.imgNewRelease)

            itembinding.imgNewRelease.setOnClickListener {
                onClickItemListener.onCLick(adapterPosition, song)
                Log.d(
                    "RRR",
                    "song.album_id : " + song.album_id
                            + "song.album_image : " + song.album_image
                            + "song.artist_id : " + song.artist_id
                            + "song.artist_idstr : " + song.artist_idstr
                            + "song.artist_name : " + song.artist_name
                            + "song.audio : " + song.audio
                            + "song.audiodownload : " + song.audiodownload
                            + "song.audiodownload_allowed : " + song.audiodownload_allowed
                            + "song.duration : " + song.duration
                            + "song.id : " + song.id
                            + "song.image : " + song.image
                            + "song.license_ccurl : " + song.license_ccurl
                            + "song.name : " + song.name
                            + "song.releasedate : " + song.releasedate
                            + "song.thumbnail : " + song.thumbnail
                )

            }

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
        return listNewRelease.size
    }
}

//    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
//        super.onDetachedFromRecyclerView(recyclerView)
//        mediaPlayer?.release()
//    }
//}