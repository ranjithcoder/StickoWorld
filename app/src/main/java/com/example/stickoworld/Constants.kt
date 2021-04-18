@file:Suppress("DEPRECATION")

package com.example.stickoworld

import android.os.Environment


object Constants {
    val STICKERS_DIRECTORY_PATH =
        Environment.getExternalStorageDirectory().toString() + "/stickerPacks/"
    val STICKERS_CREATED_DIRECTORY_PATH =
        Environment.getExternalStorageDirectory().toString() + "/stickersCreated/"
    const val STICKER_PACK_IDENTIFIER_LENGHT = 20
}
