package com.example.music.ui.component.fragment

import com.example.music.databinding.FragmentHomeBinding
import com.example.music.databinding.FragmentPlaylistBinding
import com.example.music.ui.base.BaseFragment

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding>() {
    override fun getDataBinding(): FragmentPlaylistBinding {
        return  FragmentPlaylistBinding.inflate(layoutInflater)
    }
}