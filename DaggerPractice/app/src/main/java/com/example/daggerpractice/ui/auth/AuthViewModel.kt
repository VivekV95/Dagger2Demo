package com.example.daggerpractice.ui.auth

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Singleton


class AuthViewModel @Inject constructor(): ViewModel() {

    init {
        println("It worked omg")
    }
}