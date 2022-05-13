package com.example.moviefun

import android.app.Application

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        when (BuildConfig.FLAVOR) {
            "dev" -> {}
            "stg" -> {}
            "prd" -> {}
        }
    }
}
