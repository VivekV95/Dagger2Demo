package com.example.daggerpractice.ui.auth

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(): ViewModel() {

    init {
        println("It worked omg")
    }
}