package com.example.stickoworld

public class Sticker(s: String) {
    private var mURL: String? = null

    fun Sticker(url: String?) {
        mURL = url
    }

    fun getURL(): String? {
        return mURL
    }

    fun setURL(mURL: String?) {
        this.mURL = mURL
    }
}