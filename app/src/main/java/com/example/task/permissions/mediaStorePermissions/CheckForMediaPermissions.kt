package com.example.task.permissions.mediaStorePermissions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class CheckForMediaPermissions(val context: Context) : IPermissions {

    private val readMediaRequestCode = 100

    private val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO)
    } else {
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private val checkPermission = ContextCompat.checkSelfPermission(
        context, Manifest.permission.READ_MEDIA_IMAGES,
    ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        context, Manifest.permission.READ_MEDIA_VIDEO,
    ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        context, Manifest.permission.READ_EXTERNAL_STORAGE
    ) != PackageManager.PERMISSION_GRANTED


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun checkForPermission(): Boolean {
        if (checkPermission) {

            ActivityCompat.requestPermissions(
                context as Activity, permission, readMediaRequestCode
            )


        } else {
            return true
        }
        return false
    }


}