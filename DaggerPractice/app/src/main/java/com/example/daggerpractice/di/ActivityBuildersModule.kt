package com.example.daggerpractice.di

import com.example.daggerpractice.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun constibuteAuthActivity(): AuthActivity

}