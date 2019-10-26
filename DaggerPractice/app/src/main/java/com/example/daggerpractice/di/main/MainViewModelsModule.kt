package com.example.daggerpractice.di.main

import androidx.lifecycle.ViewModel
import com.example.daggerpractice.di.ViewModelKey
import com.example.daggerpractice.ui.main.MainViewModel
import com.example.daggerpractice.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}