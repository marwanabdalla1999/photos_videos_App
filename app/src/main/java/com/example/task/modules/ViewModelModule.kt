package com.example.task.modules

import android.content.Context
import com.example.task.dataSource.mediaStore.Images
import com.example.task.dataSource.mediaStore.Videos
import com.example.task.repositories.mediaStoreRepository.IRepositoryMediaStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named


@Module
@InstallIn(ViewModelComponent::class)
object  ViewModelModule {



    @Provides
    @ViewModelScoped
    @Named("Images")
     fun getImagesMediaStore(@ApplicationContext context: Context): IRepositoryMediaStore {

         return com.example.task.repositories.mediaStoreRepository.ImagesRepo(Images(context))
     }

    @Provides
    @ViewModelScoped
    @Named("Videos")
    fun getVideosMediaStore(@ApplicationContext context: Context): IRepositoryMediaStore {

        return com.example.task.repositories.mediaStoreRepository.VideosRepo(Videos(context))
    }



}