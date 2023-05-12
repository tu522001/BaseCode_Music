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

//@HiltViewModel
//class GenresViewModel @Inject constructor(private val dataRepositoryRepository: DataRepositorySource) :
//    BaseViewModel() {
//
//    private val _genresSongs = MutableLiveData<Resource<ResponseGenres>>()
//    val genresSongs: LiveData<Resource<ResponseGenres>> get() = _genresSongs
//
//    fun getGenresSongs() {
//        viewModelScope.launch {
//            _genresSongs.value = Resource.Loading()
//            wrapEspressoIdlingResource {
//                dataRepositoryRepository.requestGenres().collect {
//                    _genresSongs.value = it
//                }
//            }
//        }
//    }
//
//}
