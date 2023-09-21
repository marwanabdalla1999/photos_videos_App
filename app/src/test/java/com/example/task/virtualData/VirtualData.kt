package com.example.task.virtualData

import com.example.task.dataSource.IDataSource


class VirtualData: IDataSource {


    override fun getData(): List<String> {

        return listOf("","","","")
    }

}