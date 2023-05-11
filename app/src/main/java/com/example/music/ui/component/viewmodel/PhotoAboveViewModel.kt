package com.example.music.ui.component.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.music.data.Resource
import com.example.music.data.dto.response.ResponseGenres
import com.example.music.data.repository.DataRepositorySource
import com.example.music.ui.base.BaseViewModel
import com.example.music.utils.wrapEspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoAboveViewModel @Inject constructor(private val dataRepositoryRepository: DataRepositorySource) :
    BaseViewModel() {

    private val _photoAbove = MutableLiveData<Resource<ResponseGenres>>()
    val photoAbove: LiveData<Resource<ResponseGenres>> get() = _photoAbove

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

}

