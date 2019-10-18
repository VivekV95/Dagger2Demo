package com.example.daggerpractice.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun someString() = "This is a test String"

        @JvmStatic
        @Provides
        fun getApp(application: Application?) = application == null
    }


}