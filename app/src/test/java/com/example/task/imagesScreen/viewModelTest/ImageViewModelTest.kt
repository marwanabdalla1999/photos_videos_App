package com.example.task.imagesScreen.viewModelTest


import com.example.task.dataSource.interfaces.IDataSource
import org.junit.Before
import org.junit.Test
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task.imagesScreen.viewModels.ImagesViewModel
import com.example.task.virtualData.VirtualData
import com.example.task.virtualRepository.VirtualImagesRepository
import org.junit.Assert
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ImageViewModelTest {

    private lateinit var moviesViewModel: ImagesViewModel
    private lateinit var virtualData: IDataSource

    @Before
    fun setUp() {
        virtualData = VirtualData()
        moviesViewModel = ImagesViewModel(VirtualImagesRepository(virtualData))

    }

    @Test
    fun getImage() {
        moviesViewModel.getImages()
        val result = moviesViewModel.observeImages()
        Assert.assertNotNull(result)

    }


}
