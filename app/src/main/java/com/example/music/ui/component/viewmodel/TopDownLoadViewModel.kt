package com.example.music.ui.component.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.music.data.Resource
import com.example.music.data.dto.response.ResponseSong
import com.example.music.data.repository.DataRepositorySource
import com.example.music.ui.base.BaseViewModel
import com.example.music.utils.wrapEspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopDownLoadViewModel @Inject constructor(private val dataRepositoryRepository: DataRepositorySource) :
    BaseViewModel() {

    private val _topDownLoadSongs = MutableLiveData<Resource<ResponseSong>>()
    val topDownLoadSongs: LiveData<Resource<ResponseSong>> get() = _topDownLoadSongs

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

}
