package com.example.music.ui.component.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.R
import com.example.music.databinding.ActivityMainBinding
import com.example.music.ui.base.BaseActivity
import com.example.music.ui.component.adapter.GenresAdapter
import com.example.music.ui.component.fragment.HomeFragment
import com.example.music.ui.component.fragment.PlaylistFragment
import com.example.music.ui.component.viewmodel.ReleaseViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(){

    private val releaseViewModel by viewModels<ReleaseViewModel>()
    override fun getViewBinding(): ActivityMainBinding {
     return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initData() {
        super.initData()
        releaseViewModel.getNetReleaseSongs(page = 1, limit = 20, "release")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        loadFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.discover -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.playlist -> {
                    loadFragment(PlaylistFragment())
                    true
                }
//                R.id.download-> {
//                    loadFragment(SettingFragment())
//                    true
//                }
//                R.id.favorite-> {
//                    loadFragment(SettingFragment())
//                    true
//                }

                else -> {
                    loadFragment(HomeFragment())
                    true
                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}