package com.example.daggerpractice.di

import com.example.daggerpractice.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun constibuteAuthActivity(): AuthActivity

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun someString(): String {
            return "this is a test string"
        }
    }
}