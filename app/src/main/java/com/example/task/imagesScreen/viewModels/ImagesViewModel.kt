package com.example.task.imagesScreen.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.repositories.interfaces.IRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class ImagesViewModel @Inject constructor(@Named("Images") private val repository: IRepo) : ViewModel() {

    private val images = MutableLiveData<List<String>>()

     suspend fun getImages(){
        images.postValue(repository.getData())
    }


    fun observeImages(): MutableLiveData<List<String>> {
            return images
    }


}