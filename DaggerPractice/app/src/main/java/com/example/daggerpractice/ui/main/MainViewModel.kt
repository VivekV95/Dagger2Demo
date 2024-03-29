package com.example.daggerpractice.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.daggerpractice.SessionManager
import com.example.daggerpractice.model.User
import com.example.daggerpractice.model.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

class MainViewModel @Inject constructor(val sessionManager: SessionManager): ViewModel() {

    var id: Int? = null

    fun observeAuthState() = sessionManager.getAuthUser()

    fun logOut() = sessionManager.logOut()


}