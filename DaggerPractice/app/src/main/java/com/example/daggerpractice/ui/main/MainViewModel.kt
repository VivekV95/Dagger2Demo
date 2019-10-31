package com.example.daggerpractice.ui.main

import androidx.lifecycle.ViewModel
import com.example.daggerpractice.SessionManager
import javax.inject.Inject

class MainViewModel @Inject constructor(val sessionManager: SessionManager): ViewModel() {

    var id: Int? = null

    fun observeAuthState() = sessionManager.getAuthUser()

    fun logOut() = sessionManager.logOut()


}