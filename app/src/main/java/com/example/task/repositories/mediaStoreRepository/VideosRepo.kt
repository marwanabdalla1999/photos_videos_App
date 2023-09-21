package com.example.task.repositories.mediaStoreRepository


import com.example.task.dataSource.interfaces.IDataSource


class VideosRepo (private val dataSource: IDataSource) : IRepositoryMediaStore {



    override suspend fun getDataFromMediaStore(): List<String> {

       return dataSource.getData()
    }






}