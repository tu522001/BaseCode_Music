package com.example.music.ui.component.activities

import android.os.Bundle
import android.util.Log
import com.example.music.data.dto.modelSong.Song
import com.example.music.databinding.ActivityMainBinding
import com.example.music.databinding.ActivityMusicPlayerBinding
import com.example.music.databinding.FragmentPlaylistBinding
import com.example.music.ui.base.BaseActivity

class MusicPlayingActivity : BaseActivity<ActivityMusicPlayerBinding>() {
    override fun getViewBinding(): ActivityMusicPlayerBinding {
        return ActivityMusicPlayerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Retrieve the data from the intent
        val song = intent.getParcelableExtra<Song>("song_object")

//        binding.progressCircular.

        Log.d("SSSD","song.id"+song!!.id+" , song.nanme : "+song!!.name)
        // Use the data in your activity
//        binding.textView4.text = myData
    }

    override fun initView() {
        super.initView()
    }

}