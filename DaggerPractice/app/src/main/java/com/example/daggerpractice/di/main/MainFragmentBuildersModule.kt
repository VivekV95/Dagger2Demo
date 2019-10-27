package com.example.daggerpractice.di.main

import com.example.daggerpractice.di.main.posts.PostsViewModelModule
import com.example.daggerpractice.di.main.posts.PostsModule
import com.example.daggerpractice.di.main.profile.ProfileViewModelModule
import com.example.daggerpractice.di.scope.PostsScope
import com.example.daggerpractice.di.scope.ProfileScope
import com.example.daggerpractice.ui.main.posts.PostsFragment
import com.example.daggerpractice.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ProfileScope
    @ContributesAndroidInjector(
        modules = [
            ProfileViewModelModule::class
        ]
    )
    abstract fun contributeProfileFragment(): ProfileFragment

    @PostsScope
    @ContributesAndroidInjector(
        modules = [
            PostsModule::class,
            PostsViewModelModule::class
        ]
    )
    abstract fun contributePostsFragment(): PostsFragment
}