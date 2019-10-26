package com.example.daggerpractice.di.main.profile

import androidx.lifecycle.ViewModel
import com.example.daggerpractice.di.ViewModelKey
import com.example.daggerpractice.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}