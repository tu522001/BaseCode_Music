package com.example.music.ui.component.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.music.data.repository.DataRepositorySource
import com.example.music.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ImageViewModel@Inject constructor(private val dataRepositoryRepository: DataRepositorySource) :
    BaseViewModel() {

    fun requestFramesImage(){
        viewModelScope.launch(Dispatchers.IO) {
            dataRepositoryRepository.requestFramesImage()
        }
    }

}