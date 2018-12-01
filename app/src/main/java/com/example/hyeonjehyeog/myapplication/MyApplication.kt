package com.example.hyeonjehyeog.myapplication

import android.app.Application
import com.example.hyeonjehyeog.myapplication.network2.ApiService
import timber.log.Timber

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        ApiService.init()
    }
}