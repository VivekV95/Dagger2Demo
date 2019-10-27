package com.example.daggerpractice.di

import com.example.daggerpractice.di.auth.AuthModule
import com.example.daggerpractice.di.auth.AuthViewModelModule
import com.example.daggerpractice.di.main.MainFragmentBuildersModule
import com.example.daggerpractice.di.main.MainModule
import com.example.daggerpractice.di.main.MainViewModelModule
import com.example.daggerpractice.di.scope.AuthScope
import com.example.daggerpractice.di.scope.MainScope
import com.example.daggerpractice.ui.auth.AuthActivity
import com.example.daggerpractice.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [
            AuthModule::class,
            AuthViewModelModule::class
        ]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @MainScope
    @ContributesAndroidInjector(
        modules = [
            MainFragmentBuildersModule::class,
            MainViewModelModule::class,
            MainModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

}