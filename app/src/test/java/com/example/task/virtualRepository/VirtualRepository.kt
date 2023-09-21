package com.example.task.virtualRepository

import com.example.task.dataSource.IDataSource
import com.example.task.repositories.mediaStoreRepository.IRepositoryMediaStore

class VirtualRepository(private val virtualData: IDataSource) : IRepositoryMediaStore {

    override suspend fun getDataFromMediaStore(): List<String> {

            return virtualData.getData()
    }
}