package com.example.daggerpractice

import com.example.daggerpractice.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class BaseApplication : DaggerApplication() {

    override fun applicationInjector() =
        DaggerAppComponent
            .builder()
            .application(this)
            .build()


}