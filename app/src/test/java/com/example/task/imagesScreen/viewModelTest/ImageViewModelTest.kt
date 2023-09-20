package com.example.task.imagesScreen.viewModelTest


import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task.dataSource.interfaces.IDataSource
import com.example.task.imagesScreen.viewModels.ImagesViewModel
import com.example.task.virtualData.VirtualData
import com.example.task.virtualRepository.VirtualImagesRepository
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


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
