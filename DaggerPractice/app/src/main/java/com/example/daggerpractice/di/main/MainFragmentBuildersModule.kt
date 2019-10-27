package com.example.daggerpractice.di.main

import com.example.daggerpractice.di.main.posts.PostsModule
import com.example.daggerpractice.ui.main.posts.PostsFragment
import com.example.daggerpractice.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(
        modules = [
            PostsModule::class
        ]
    )
    abstract fun contributePostsFragment(): PostsFragment
}