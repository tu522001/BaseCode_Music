package com.example.music.ui.component.fragment

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.R
import com.example.music.data.Resource
import com.example.music.data.dto.modelSong.Genres
import com.example.music.data.dto.modelSong.Song
import com.example.music.data.dto.response.ResponseGenres
import com.example.music.data.dto.response.ResponseSong
import com.example.music.databinding.FragmentHomeBinding
import com.example.music.ui.base.BaseFragment
import com.example.music.ui.base.listeners.onClickItemListener
import com.example.music.ui.component.activities.MusicPlayingActivity
import com.example.music.ui.component.adapter.*
import com.example.music.ui.component.viewmodel.*
import com.example.music.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), onClickItemListener {

    private val releaseViewModel by activityViewModels<ReleaseViewModel>()
    private val topTrendingViewModel by activityViewModels<TopTrendingViewModel>()
    private val topDownLoadViewModel by activityViewModels<TopDownLoadViewModel>()
    private val genresViewModel by activityViewModels<GenresViewModel>()
    private val photoAboveViewModel by activityViewModels<PhotoAboveViewModel>()
//    private val searchViewModel by viewModels<SearchViewModel>()

//    private val topTrendingViewModel by viewModels<TopTrendingViewModel>()
//    private val topDownLoadViewModel by viewModels<TopDownLoadViewModel>()
//    private val genresViewModel by viewModels<GenresViewModel>()
//    private val photoAboveViewModel by viewModels<PhotoAboveViewModel>()
//    private val searchViewModel by viewModels<SearchViewModel>()

    private lateinit var genresAdapter: GenresAdapter
    private lateinit var newReleaseAdapter: NewReleaseAdapter
    private lateinit var topDownloadAdapter: TopDownloadAdapter
    private lateinit var topTrendingAdapter: TopTrendingAdapter
    private lateinit var photoAboveAdapter: PhotoAboveAdapter

    private var mTimer: Timer? = null
    private var photoList: List<String> = listOf()
    private var genresList: List<Genres> = listOf()
    private var newReleaseList: List<Song> = listOf()
    private var searchList: List<Song> = listOf()
    private var topTrendingList: List<Song> = listOf()
    private var topDownLoadList: List<Song> = listOf()

    override fun getDataBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
//        genresList = Song.dataSongFake()

        val linearLayoutManager = LinearLayoutManager(this.requireContext())

        //Genres
        binding.recyclerViewGenres.layoutManager = linearLayoutManager

        genresAdapter = GenresAdapter(this.requireContext(), genresList.toMutableList())
        binding.recyclerViewGenres.adapter = genresAdapter

        binding.recyclerViewGenres.setHasFixedSize(true)
        binding.recyclerViewGenres.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // New Release
        binding.recyclerViewNewRelease.layoutManager = linearLayoutManager

        newReleaseAdapter =
            NewReleaseAdapter(this.requireContext(), this, newReleaseList.toMutableList())
        binding.recyclerViewNewRelease.adapter = newReleaseAdapter

        binding.recyclerViewNewRelease.setHasFixedSize(true)
        binding.recyclerViewNewRelease.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // Top Trending
        binding.recyclerViewTopTrending.layoutManager = linearLayoutManager

        topTrendingAdapter =
            TopTrendingAdapter(this.requireContext(), topTrendingList.toMutableList())
        binding.recyclerViewTopTrending.adapter = topTrendingAdapter

        binding.recyclerViewTopTrending.setHasFixedSize(true)
        binding.recyclerViewTopTrending.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // TopDownLoad
        binding.recyclerViewTopDownload.layoutManager = linearLayoutManager

        topDownloadAdapter =
            TopDownloadAdapter(this.requireContext(), topDownLoadList.toMutableList())
        binding.recyclerViewTopDownload.adapter = topDownloadAdapter

        binding.recyclerViewTopDownload.setHasFixedSize(true)
        binding.recyclerViewTopDownload.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        photoAboveAdapter = PhotoAboveAdapter(
            this.requireContext(),
            photoList.toMutableList()
        )
        binding.viewpager.adapter = photoAboveAdapter

        binding.circleIndicator.setViewPager(binding.viewpager)
        photoAboveAdapter.registerDataSetObserver(binding.circleIndicator.dataSetObserver)

        autoSlideImages()

        binding.imgBtnSearch.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_musicPlayingFragment)
        }

    }

    // tự động chuyển ảnh photo above
    private fun autoSlideImages() {
        // Init timer
        if (mTimer == null) {
            mTimer = Timer()
        }

        mTimer?.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    val currentItem = binding.viewpager.currentItem
                    val totalItem = photoList.size - 1
                    binding.viewpager.currentItem =
                        if (currentItem < totalItem) currentItem + 1 else 0
                }
            }
        }, 500, 3000)
    }

    override fun initData() {
        super.initData()
//        releaseViewModel.getNetReleaseSongs(page = 1, limit = 20, "release")
//        topTrendingViewModel.getTopTrendingSongs(page = 1, limit = 20, "trending")
//        topDownLoadViewModel.getTopDownLoadSongs(page = 1, limit = 5, "download")
//        genresViewModel.getGenresSongs()
//        photoAboveViewModel.getPhotoAbove()
//        searchViewModel.getSearchSongs(1, 20, "release", "")
    }

    override fun addObservers() {
        // observe LiveData
        observe(releaseViewModel.newReleaseSongs, ::handleNewReleaseSong)
        observe(topTrendingViewModel.topTrendingSongs, ::handleTopTrendingSong)
        observe(topDownLoadViewModel.topDownLoadSongs, ::handleTopDownLoadSong)
        observe(genresViewModel.genresSongs, ::handleGenresSong)
//        observe(searchViewModel.searchSongs, ::handleSearchSong)
    }

    private fun handleNewReleaseSong(resource: Resource<ResponseSong>) {
        if (resource.data != null) {
            resource.data.let {
                newReleaseList = it.data
            }
            newReleaseAdapter.updateData(newReleaseList)

        }
    }

    private fun handleTopTrendingSong(resource: Resource<ResponseSong>) {
        if (resource.data != null) {
            resource.data.let {
                topTrendingList = it.data
            }
            topTrendingAdapter.updateData(topTrendingList)

        }
    }

    private fun handleTopDownLoadSong(resource: Resource<ResponseSong>) {
        if (resource.data != null) {
            resource.data.let {
                topDownLoadList = it.data
            }
            topDownloadAdapter.updateData(topDownLoadList)

        }
    }

    private fun handleGenresSong(resource: Resource<ResponseGenres>) {
        if (resource.data != null) {
            resource.data.let {
                genresList = it.data
            }
            resource.data.ads.let {
                photoList = it
            }
            genresAdapter.updateData(genresList)
            photoAboveAdapter.updateData(photoList)
        }
    }

    private fun handleSearchSong(resource: Resource<ResponseSong>) {
        if (resource.data != null) {
            resource.data.let {
                searchList = it.data
            }


        }
    }

    override fun onCLick(position: Int, song: Song) {
        Log.d("RRR", "position : " + position + " , song : " + song)
        val myObject = Song(
            song.album_id,
            song.album_image,
            song.album_name,
            song.artist_id,
            song.artist_idstr,
            song.artist_name,
            song.audio,
            song.audiodownload,
            song.audiodownload_allowed,
            song.duration,
            song.id,
            song.image,
            song.license_ccurl,
            song.name,
            song.releasedate,
            song.thumbnail
        )
        val intent = Intent(activity, MusicPlayingActivity::class.java)
        intent.putExtra("song_object", myObject)
        startActivity(intent)


    }

}