package com.example.daggerpractice.di.main.profile

import com.example.daggerpractice.di.scope.ProfileScope
import com.example.daggerpractice.ui.main.profile.ProfileFragment
import dagger.Subcomponent

@ProfileScope
@Subcomponent(
    modules = [
        ProfileViewModelModule::class]
)
interface ProfileComponent {

    fun inject(fragment: ProfileFragment)
}