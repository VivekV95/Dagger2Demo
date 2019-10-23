package com.example.daggerpractice.ui.auth

import androidx.lifecycle.ViewModel
import com.example.daggerpractice.network.auth.AuthApi
import javax.inject.Inject
import javax.inject.Singleton


class AuthViewModel @Inject constructor(authApi: AuthApi): ViewModel() {

    init {
        println("It worked omg")
    }
}