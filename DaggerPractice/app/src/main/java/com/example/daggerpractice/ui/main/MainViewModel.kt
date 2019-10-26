package com.example.daggerpractice.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.daggerpractice.SessionManager
import com.example.daggerpractice.model.User
import com.example.daggerpractice.ui.auth.AuthResource
import javax.inject.Inject

class MainViewModel @Inject constructor(private val sessionManager: SessionManager): ViewModel() {

    fun observeAuthState(): LiveData<AuthResource<User>> = sessionManager.getAuthUser()

    fun logOut() {
        sessionManager.logOut()
    }

}