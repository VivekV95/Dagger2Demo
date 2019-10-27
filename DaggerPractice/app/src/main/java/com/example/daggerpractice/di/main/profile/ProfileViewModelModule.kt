package com.example.daggerpractice.di.main.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerpractice.di.ViewModelKey
import com.example.daggerpractice.di.scope.AuthScope
import com.example.daggerpractice.di.scope.ProfileScope
import com.example.daggerpractice.ui.main.profile.ProfileViewModel
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileViewModelModule {

    @ProfileScope
    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @ProfileScope
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}