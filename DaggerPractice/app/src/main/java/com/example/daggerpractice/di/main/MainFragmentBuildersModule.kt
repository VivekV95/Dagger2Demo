package com.example.daggerpractice.di.main

import com.example.daggerpractice.di.main.profile.ProfileViewModelsModule
import com.example.daggerpractice.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector(
        modules = [
        ProfileViewModelsModule::class
        ]
    )
    abstract fun contributeProfileFragment(): ProfileFragment
}