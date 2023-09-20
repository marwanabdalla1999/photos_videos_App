package com.example.task.repositories.interfaces



interface IRepo {

     suspend fun getData(): List<String>
}