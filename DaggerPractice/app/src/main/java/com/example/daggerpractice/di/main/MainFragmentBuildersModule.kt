package com.example.daggerpractice.di.main

import com.example.daggerpractice.di.main.posts.PostsModule
import com.example.daggerpractice.di.main.posts.PostsViewModelsModule
import com.example.daggerpractice.di.main.profile.ProfileViewModelsModule
import com.example.daggerpractice.ui.main.posts.PostsFragment
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

    @ContributesAndroidInjector(
        modules = [
            PostsViewModelsModule::class,
            PostsModule::class
        ]
    )
    abstract fun contributePostsFragment(): PostsFragment
}