package com.example.task.repositories.mediaStoreRepository


import com.example.task.dataSource.IDataSource


class RepositoryMediaStore (private val dataSource: IDataSource) : IRepositoryMediaStore {



    override  suspend fun getDataFromMediaStore(): List<String> {

        return dataSource.getData()
    }


}