package com.example.gonavi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GithubApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}