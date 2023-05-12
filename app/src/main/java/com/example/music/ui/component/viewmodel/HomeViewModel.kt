package com.example.music.ui.component.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.music.data.Resource
import com.example.music.data.dto.response.ResponseGenres
import com.example.music.data.dto.response.ResponseSong
import com.example.music.data.repository.DataRepositorySource
import com.example.music.ui.base.BaseViewModel
import com.example.music.utils.wrapEspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val dataRepositoryRepository: DataRepositorySource) :
    BaseViewModel() {

    private val _genresSongs = MutableLiveData<Resource<ResponseGenres>>()
    val genresSongs: LiveData<Resource<ResponseGenres>> get() = _genresSongs

    private val _photoAbove = MutableLiveData<Resource<ResponseGenres>>()
    val photoAbove: LiveData<Resource<ResponseGenres>> get() = _photoAbove

    private val _newReleaseSongs = MutableLiveData<Resource<ResponseSong>>()
    val newReleaseSongs: LiveData<Resource<ResponseSong>> get() = _newReleaseSongs

    private val _topDownLoadSongs = MutableLiveData<Resource<ResponseSong>>()
    val topDownLoadSongs: LiveData<Resource<ResponseSong>> get() = _topDownLoadSongs

    private val _topTrendingSongs = MutableLiveData<Resource<ResponseSong>>()
    val topTrendingSongs: LiveData<Resource<ResponseSong>> get() = _topTrendingSongs


    fun getGenresSongs() {
        viewModelScope.launch {
            _genresSongs.value = Resource.Loading()
            wrapEspressoIdlingResource {
                dataRepositoryRepository.requestGenres().collect {
                    _genresSongs.value = it
                }
            }
        }
    }

    fun getPhotoAbove() {
        viewModelScope.launch {
            _photoAbove.value = Resource.Loading()
            wrapEspressoIdlingResource {
                dataRepositoryRepository.requestPhotoAbove().collect {
                    _photoAbove.value = it
                }
            }
        }
    }

    fun getNetReleaseSongs(page: Int, limit: Int, order: String) {
        viewModelScope.launch {
            _newReleaseSongs.value = Resource.Loading()
            wrapEspressoIdlingResource {
                dataRepositoryRepository.requestNewReleaseSong(page,limit,order).collect {
                    _newReleaseSongs.value = it
                }
            }
        }
    }

    fun getTopDownLoadSongs(page: Int, limit: Int, order: String) {
        viewModelScope.launch {
            _topDownLoadSongs.value = Resource.Loading()
            wrapEspressoIdlingResource {
                dataRepositoryRepository.requestNewReleaseSong(page,limit,order).collect {
                    _topDownLoadSongs.value = it
                }
            }
        }
    }

    fun getTopTrendingSongs(page: Int, limit: Int, order: String) {
        viewModelScope.launch {
            _topTrendingSongs.value = Resource.Loading()
            wrapEspressoIdlingResource {
                dataRepositoryRepository.requestTopTrendingSong(page,limit,order).collect {
                    _topTrendingSongs.value = it
                }
            }
        }
    }
}
