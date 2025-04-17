package com.henryadamsjr.wallflipper

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit


class MyApp : Application(), Configuration.Provider {

    override fun onCreate() {
        super.onCreate()

        val workRequest = PeriodicWorkRequestBuilder<FooWorker>(
            15, TimeUnit.MINUTES // Minimum repeat interval
        ).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "MyPeriodicWork",                             // A unique name for the work
            ExistingPeriodicWorkPolicy.KEEP,              // Avoids creating duplicate work
            workRequest
        )
    }

    override val workManagerConfiguration = Configuration.Builder()
        .setMinimumLoggingLevel(Log.INFO)
        .build()
}