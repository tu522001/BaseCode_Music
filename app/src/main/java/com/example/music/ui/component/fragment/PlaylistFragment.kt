package com.example.music.ui.component.fragment

import com.example.music.databinding.FragmentHomeBinding
import com.example.music.databinding.FragmentPlaylistBinding
import com.example.music.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaylistFragment : BaseFragment<FragmentPlaylistBinding>() {
    override fun getDataBinding(): FragmentPlaylistBinding {
        return  FragmentPlaylistBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }
}