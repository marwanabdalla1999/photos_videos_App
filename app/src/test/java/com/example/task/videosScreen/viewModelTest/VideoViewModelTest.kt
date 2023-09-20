package com.example.task.videosScreen.viewModelTest


import com.example.task.dataSource.interfaces.IDataSource
import org.junit.Before
import org.junit.Test
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task.videosScreen.viewModels.VideosViewModel
import com.example.task.virtualData.VirtualData
import com.example.task.virtualRepository.VirtualImagesRepository
import org.junit.Assert
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class VideoViewModelTest {

    private lateinit var videoViewModel: VideosViewModel
    private lateinit var virtualData: IDataSource

    @Before
    fun setUp() {
        virtualData = VirtualData()
        videoViewModel = VideosViewModel(VirtualImagesRepository(virtualData))

    }

    @Test
    fun getImage() {
        videoViewModel.getVideos()
        val result = videoViewModel.observeVideos()
        Assert.assertNotNull(result)

    }


}
