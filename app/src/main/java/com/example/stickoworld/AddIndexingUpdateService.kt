package com.example.stickoworld

import android.content.Context
import android.content.Intent
import androidx.annotation.NonNull
import androidx.core.app.JobIntentService
import com.google.firebase.appindexing.FirebaseAppIndex


@Suppress("DEPRECATION", "UNREACHABLE_CODE")
public class AppIndexingUpdateService : JobIntentService() {
    // Job-ID must be unique across your whole app.
    private val UNIQUE_JOB_ID = 42

    public fun enqueueWork(context: Context?) {
        enqueueWork(context!!, AppIndexingUpdateService::class.java, UNIQUE_JOB_ID, Intent())
    }

    override fun onHandleWork(intent: Intent) {
        TODO("Not yet implemented")
        AppIndexingUtil.setStickers(applicationContext, FirebaseAppIndex.getInstance())
    }
}