package com.example.music.ui.component.splash

import android.os.Bundle
import com.example.music.databinding.SplashLayoutBinding
import com.example.music.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by TruyenIT
 */
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private lateinit var binding: SplashLayoutBinding

    override fun initViewBinding() {
        binding = SplashLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun observeViewModel() {
    }


}
