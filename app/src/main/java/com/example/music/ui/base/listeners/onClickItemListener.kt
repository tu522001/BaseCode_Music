package com.example.music.ui.base.listeners

import com.example.music.data.dto.modelSong.Song

interface onClickItemListener {
    fun onCLick(position : Int, song: Song)
}