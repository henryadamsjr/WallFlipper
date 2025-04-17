package com.henryadamsjr.wallflipper

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class FooWorker (appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d("MyPeriodicWorker", "Running periodic work")
        return Result.success()
    }
}