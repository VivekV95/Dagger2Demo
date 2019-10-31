package com.example.daggerpractice.di.main

import com.example.daggerpractice.di.main.MainModule
import com.example.daggerpractice.di.main.MainViewModelModule
import com.example.daggerpractice.di.scope.MainScope
import com.example.daggerpractice.ui.main.MainActivity
import dagger.Component
import dagger.Subcomponent

@MainScope
@Subcomponent(
    modules = [
        MainModule::class,
        MainViewModelModule::class]
)
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}

//      MainFragmentBuildersModule::class,
//            MainViewModelModule::class,
//            MainModule::class