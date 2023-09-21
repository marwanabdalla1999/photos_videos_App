package com.example.task.dataSource.mediaStore

import android.content.Context
import android.provider.MediaStore
import com.example.task.dataSource.IDataSource

class Images(val context: Context) : IDataSource {

    override   fun getData():List<String> {
        val photos = mutableListOf<String>()

        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val sortOrder = "${MediaStore.Images.Media.DATE_ADDED} DESC"


        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, sortOrder
        )

        cursor?.use {
            val columnIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            while (it.moveToNext()) {
                val imagePath = it.getString(columnIndex)
                photos.add(imagePath)
            }
        }

        return photos
    }

}