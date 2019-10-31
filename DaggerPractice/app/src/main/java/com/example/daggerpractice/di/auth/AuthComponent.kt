package com.example.daggerpractice.di.auth

import com.example.daggerpractice.di.auth.AuthModule
import com.example.daggerpractice.di.auth.AuthViewModelModule
import com.example.daggerpractice.di.scope.AuthScope
import com.example.daggerpractice.ui.auth.AuthActivity
import dagger.Subcomponent

@AuthScope
@Subcomponent(
    modules = [
        AuthModule::class,
        AuthViewModelModule::class
    ]
)
interface AuthComponent {
    fun inject(activity: AuthActivity)
}