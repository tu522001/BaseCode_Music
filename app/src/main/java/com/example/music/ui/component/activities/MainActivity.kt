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
import com.example.music.ui.component.viewmodel.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val releaseViewModel by viewModels<HomeViewModel>()
    private val topTrendingViewModel by viewModels<HomeViewModel>()
    private val topDownLoadViewModel by viewModels<HomeViewModel>()
    private val genresViewModel by viewModels<HomeViewModel>()
    private val photoAboveViewModel by viewModels<HomeViewModel>()

    /** Chuyển hết các ViewModel như ReleaseViewModel, TopTrendingViewModel, GenresViewModel, PhotoAboveViewModel
        gộp lại gọi hết vào cái HomeViewModel để dễ dàng cho việc quản lý ứng dụng */
//    private val releaseViewModel by viewModels<ReleaseViewModel>()
//    private val topTrendingViewModel by viewModels<TopTrendingViewModel>()
//    private val topDownLoadViewModel by viewModels<TopDownLoadViewModel>()
//    private val genresViewModel by viewModels<GenresViewModel>()
//    private val photoAboveViewModel by viewModels<PhotoAboveViewModel>()

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initData() {
        super.initData()
        /** viết ViewModel vào View để dữ liệu cập nhập trực tiếp từ dữ liệu ViewModel trong View nghĩa là
        khi tôi chuyển màn từ Discover sang các màn khác ví dụ : khi tôi chuyển từ màn Discover sang Playlist xong tôi lại chuyển lại
        từ màn Playlist sang màn Discover thì dữ liệu của tôi đã được cập nhật luôn trực tiếp khi vào view rồi không cần phải thông
        qua ViewModel xong với về view nữa */
        releaseViewModel.getNetReleaseSongs(page = 1, limit = 20, "release")
        topTrendingViewModel.getTopTrendingSongs(page = 1, limit = 20, "trending")
        topDownLoadViewModel.getTopDownLoadSongs(page = 1, limit = 5, "download")
        genresViewModel.getGenresSongs()
        photoAboveViewModel.getPhotoAbove()
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

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}