package com.example.task.virtualRepository

import com.example.task.dataSource.interfaces.IDataSource
import com.example.task.repositories.interfaces.IRepo

class VirtualImagesRepository(private val virtualData: IDataSource) :IRepo {

    override suspend fun getData(): List<String> {

            return virtualData.getData()
    }
}