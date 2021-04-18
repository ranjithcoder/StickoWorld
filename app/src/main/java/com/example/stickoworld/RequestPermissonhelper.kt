package com.example.stickoworld

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


object RequestPermissionsHelper {
    private const val CODE_REQUEST_WRITE_READ_EXTERNAL_STORAGE = 0
    fun verifyPermissions(context: Context?): Boolean {
        val permissionToWriteCheck =
            ContextCompat.checkSelfPermission(context!!, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permissionToReadCheck =
            ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
        return if (permissionToWriteCheck == PackageManager.PERMISSION_DENIED && permissionToReadCheck == PackageManager.PERMISSION_DENIED) {
            false
        } else true
    }

    fun requestPermissions(context: Activity?) {
        ActivityCompat.requestPermissions(context!!,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE),
            CODE_REQUEST_WRITE_READ_EXTERNAL_STORAGE)
    }
}
