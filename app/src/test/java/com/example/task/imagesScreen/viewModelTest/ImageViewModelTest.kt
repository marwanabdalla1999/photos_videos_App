package com.example.task.imagesScreen.viewModelTest


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task.dataSource.IDataSource
import com.example.task.imagesScreen.viewModels.ImagesViewModel
import com.example.task.utils.getOrAwaitValue
import com.example.task.virtualData.VirtualData
import com.example.task.virtualRepository.VirtualRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ImageViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var imagesViewModel: ImagesViewModel
    private lateinit var virtualData: IDataSource

    @Before
    fun setUp() {

        virtualData = VirtualData()
        imagesViewModel = ImagesViewModel(VirtualRepository(virtualData))

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testImages() = runTest(UnconfinedTestDispatcher()) {
        imagesViewModel.getImages()
        val data = imagesViewModel.observeImages().getOrAwaitValue { }
        Assert.assertNotNull(data)
        Assert.assertTrue(data.isNotEmpty())

    }


}
