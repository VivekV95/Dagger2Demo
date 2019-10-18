package com.example.daggerpractice.di

import com.example.daggerpractice.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun constibuteAuthActivity(): AuthActivity

}