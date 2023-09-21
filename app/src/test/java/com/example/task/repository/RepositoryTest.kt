package com.example.task.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task.dataSource.interfaces.IDataSource
import com.example.task.repositories.mediaStoreRepository.IRepositoryMediaStore
import com.example.task.virtualData.VirtualData
import com.example.task.virtualRepository.VirtualRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RepositoryTest {


    private lateinit var localDataSource: IDataSource
    private lateinit var repository: IRepositoryMediaStore


    @Before
    fun setUp(){
        localDataSource = VirtualData()
        repository = VirtualRepository(localDataSource)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getImages()= runTest (UnconfinedTestDispatcher()){
        var  data:List<String>? = null
        launch {
            data =repository.getDataFromMediaStore()
        }
        Assert.assertNotNull(data)
        Assert.assertTrue(data?.isNotEmpty() ?: false)
    }

}