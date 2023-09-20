package com.example.task.dataSource.mediaStore

import android.content.Context
import android.provider.MediaStore
import com.example.task.dataSource.interfaces.IDataSource

class Videos(val context: Context) : IDataSource {


    override   fun getData():List<String> {
        val videos = mutableListOf<String>()

        val projection = arrayOf(MediaStore.Video.Media.DATA)
        val sortOrder = "${MediaStore.Images.Media.DATE_ADDED} DESC"

        val cursor = context.contentResolver.query(
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, sortOrder
        )

        cursor?.use {
            val columnIndex = it.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)
            while (it.moveToNext()) {
                val videoImagePath = it.getString(columnIndex)
                videos.add(videoImagePath)
            }
        }
        return videos
    }
}