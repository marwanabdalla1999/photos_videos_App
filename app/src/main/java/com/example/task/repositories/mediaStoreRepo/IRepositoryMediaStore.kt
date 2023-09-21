package com.example.task.repositories.mediaStoreRepo



interface IRepositoryMediaStore {

     suspend fun getDataFromMediaStore(): List<String>
}