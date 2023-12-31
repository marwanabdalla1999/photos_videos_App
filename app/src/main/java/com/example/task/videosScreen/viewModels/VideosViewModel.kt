package com.example.task.videosScreen.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.repositories.mediaStoreRepository.IRepositoryMediaStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class VideosViewModel @Inject  constructor(@Named("Videos") private val repository: IRepositoryMediaStore) : ViewModel() {

private val videos =MutableLiveData<List<String>>()

      fun getVideos(){
         viewModelScope.launch {
             videos.postValue(repository.getDataFromMediaStore())
         }
    }


    fun observeVideos(): MutableLiveData<List<String>> = videos


}