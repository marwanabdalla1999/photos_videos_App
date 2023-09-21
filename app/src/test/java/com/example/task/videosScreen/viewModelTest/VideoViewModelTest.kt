package com.example.task.videosScreen.viewModelTest


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.dataSource.IDataSource
import org.junit.Before
import org.junit.Test
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task.utils.getOrAwaitValue
import com.example.task.videosScreen.viewModels.VideosViewModel
import com.example.task.virtualData.VirtualData
import com.example.task.virtualRepository.VirtualRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class VideoViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var videoViewModel: VideosViewModel
    private lateinit var virtualData: IDataSource

    @Before
    fun setUp() {
        virtualData = VirtualData()
        videoViewModel = VideosViewModel(VirtualRepository(virtualData))

    }

    @Test
    fun testVideos() = runTest {
        videoViewModel.getVideos()
        val data = videoViewModel.observeVideos().getOrAwaitValue { }
        Assert.assertNotNull(data)
        Assert.assertTrue(data.isNotEmpty())
        }
    }



