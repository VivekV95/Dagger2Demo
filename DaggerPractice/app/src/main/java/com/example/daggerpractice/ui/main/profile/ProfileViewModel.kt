package com.example.daggerpractice.ui.main.profile

import androidx.lifecycle.ViewModel
import com.example.daggerpractice.SessionManager
import javax.inject.Inject

class ProfileViewModel @Inject constructor(val sessionManager: SessionManager): ViewModel() {

    fun observeAuthState() = sessionManager.getAuthUser()

}