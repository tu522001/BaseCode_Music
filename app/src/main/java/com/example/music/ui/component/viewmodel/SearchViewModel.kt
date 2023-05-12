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
class SearchViewModel @Inject constructor(private val dataRepositoryRepository: DataRepositorySource) :
    BaseViewModel() {

    private val _searchSongs = MutableLiveData<Resource<ResponseSong>>()
    val searchSongs: LiveData<Resource<ResponseSong>> get() = _searchSongs

    fun getSearchSongs(page: Int, limit: Int, order: String, name : String) {
        viewModelScope.launch {
            _searchSongs.value = Resource.Loading()
            wrapEspressoIdlingResource {
                dataRepositoryRepository.requestSearchSong(page,limit,order,name).collect {
                    _searchSongs.value = it
                }
            }
        }
    }

}
