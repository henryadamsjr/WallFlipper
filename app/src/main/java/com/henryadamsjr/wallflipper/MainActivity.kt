package com.henryadamsjr.wallflipper

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Configuration
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), Configuration.Provider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MyPeriodicWorker", "Create")

        val constraints = Constraints.Builder()
            .setRequiresDeviceIdle(true)
            .build()

        val workRequest = PeriodicWorkRequestBuilder<FooWorker>(
            15, TimeUnit.MINUTES
        )
            //.setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "MyPeriodicWork",
            ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
            workRequest
        )
    }

    override val workManagerConfiguration = Configuration.Builder()
        .setMinimumLoggingLevel(Log.INFO)
        .build()
}
