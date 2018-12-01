package com.example.hyeonjehyeog.myapplication

import android.app.Application
import timber.log.Timber

class MyApplication2: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}