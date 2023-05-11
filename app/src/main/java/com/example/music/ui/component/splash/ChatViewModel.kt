package com.example.music.ui.component.splash

import androidx.lifecycle.viewModelScope
import com.example.music.data.repository.DataRepositorySource
import com.example.music.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChatViewModel @Inject constructor(private val dataRepositoryRepository: DataRepositorySource) :
    BaseViewModel() {

        fun signup(){
            viewModelScope.launch(Dispatchers.IO) {
                dataRepositoryRepository.signup("","")
            }
        }


}