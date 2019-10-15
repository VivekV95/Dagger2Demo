package com.example.daggerpractice.di

import com.example.daggerpractice.BaseApplication
import dagger.Component
import dagger.android.AndroidInjector

@Component
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}