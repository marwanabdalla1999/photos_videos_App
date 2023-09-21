package com.example.task.virtualRepository

import com.example.task.dataSource.interfaces.IDataSource
import com.example.task.repositories.mediaStoreRepo.IRepositoryMediaStore

class VirtualRepository(private val virtualData: IDataSource) : IRepositoryMediaStore {

    override suspend fun getDataFromMediaStore(): List<String> {

            return virtualData.getData()
    }
}