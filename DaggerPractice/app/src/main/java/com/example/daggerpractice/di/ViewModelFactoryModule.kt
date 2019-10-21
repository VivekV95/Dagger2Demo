package com.example.daggerpractice.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}