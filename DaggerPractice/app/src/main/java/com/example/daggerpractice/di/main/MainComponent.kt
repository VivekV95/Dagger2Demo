package com.example.daggerpractice.di.main

import com.example.daggerpractice.di.main.posts.PostsComponent
import com.example.daggerpractice.di.main.profile.ProfileComponent
import com.example.daggerpractice.di.scope.MainScope
import com.example.daggerpractice.ui.main.MainActivity
import dagger.Subcomponent

@MainScope
@Subcomponent(
    modules = [
        MainModule::class,
        MainViewModelModule::class]
)
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun postsComponent(): PostsComponent

    fun profileComponent(): ProfileComponent
}

//      MainFragmentBuildersModule::class,
//            MainViewModelModule::class,
//            MainModule::class