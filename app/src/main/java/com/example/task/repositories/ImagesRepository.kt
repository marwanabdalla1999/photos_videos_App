package com.example.task.repositories


import com.example.task.dataSource.interfaces.IDataSource
import com.example.task.repositories.interfaces.IRepo


class ImagesRepository (private val dataSource: IDataSource) : IRepo {



    override  suspend fun getData(): List<String> {

        return dataSource.getData()
    }


}