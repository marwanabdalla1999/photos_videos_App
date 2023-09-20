package com.example.task.modules

import com.example.task.imagesScreen.adapters.ImagesAdapter
import com.example.task.videosScreen.adapters.VideosAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Singleton
    @Provides
    fun getVideosAdapter(): VideosAdapter {

        return VideosAdapter()

    }
    @Singleton
    @Provides
    fun getImagesAdapter(): ImagesAdapter {

        return ImagesAdapter()

    }


}