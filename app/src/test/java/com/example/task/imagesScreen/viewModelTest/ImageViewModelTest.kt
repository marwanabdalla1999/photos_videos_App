package com.example.task.imagesScreen.viewModelTest


import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task.dataSource.interfaces.IDataSource
import com.example.task.imagesScreen.viewModels.ImagesViewModel
import com.example.task.virtualData.VirtualData
import com.example.task.virtualRepository.VirtualImagesRepository

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class ImageViewModelTest {

    private lateinit var ImagesViewModel: ImagesViewModel
    private lateinit var virtualData: IDataSource


    @Before
    fun setUp() {

        virtualData = VirtualData()
        ImagesViewModel = ImagesViewModel(VirtualImagesRepository(virtualData))

    }

    @Test
    fun testImages() = runTest {
        ImagesViewModel.getImages()
        ImagesViewModel.observeImages().observeForever { data ->
            Assert.assertNotNull(data)
            Assert.assertTrue(data.isNotEmpty())
        }
    }


}
