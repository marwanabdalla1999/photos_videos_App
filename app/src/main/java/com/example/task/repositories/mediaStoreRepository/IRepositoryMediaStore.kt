package com.example.task.repositories.mediaStoreRepository



interface IRepositoryMediaStore {

     suspend fun getDataFromMediaStore(): List<String>
}