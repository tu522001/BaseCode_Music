package com.example.music.ui.component.splash

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.music.databinding.ActivityMainBinding
import com.example.music.databinding.SplashLayoutBinding
import com.example.music.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by TruyenIT
 */
@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashLayoutBinding>() {
    private val chatViewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        chatViewModel.signup()
    }

    override fun getViewBinding(): SplashLayoutBinding {
        return SplashLayoutBinding.inflate(layoutInflater)
    }

}
