package com.example.daggerpractice

import android.app.Application
import com.example.daggerpractice.di.DaggerAppComponent
class BaseApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent
            .builder()
            .bindApplication(this)
            .build()
    }
}