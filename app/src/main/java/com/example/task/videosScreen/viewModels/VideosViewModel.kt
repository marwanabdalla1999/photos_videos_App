package com.example.task.videosScreen.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.repositories.interfaces.IRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class VideosViewModel @Inject  constructor(@Named("Videos") private val repository: IRepo) : ViewModel() {

private val videos =MutableLiveData<List<String>>()

     suspend fun getVideos(){

        videos.postValue(repository.getData())
    }


    fun observeVideos(): MutableLiveData<List<String>> {
        return videos
    }

}