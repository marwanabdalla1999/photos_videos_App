package com.example.task.repositories.mediaStoreRepo


import com.example.task.dataSource.interfaces.IDataSource


class ImagesRepository (private val dataSource: IDataSource) : IRepositoryMediaStore {



    override  suspend fun getDataFromMediaStore(): List<String> {

        return dataSource.getData()
    }


}