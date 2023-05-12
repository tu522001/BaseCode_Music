package com.example.music.ui.component.fragment

import com.example.music.databinding.FragmentSearchBinding
import com.example.music.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override fun getDataBinding(): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }
}