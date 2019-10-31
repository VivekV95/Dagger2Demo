package com.example.daggerpractice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.daggerpractice.model.AuthResource
import com.example.daggerpractice.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val cachedUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithId(source: LiveData<AuthResource<User>>) {
        cachedUser.value = AuthResource.Loading()
        cachedUser.addSource(source) { user ->
            cachedUser.value = user
            cachedUser.removeSource(source)
        }
    }

    fun logOut() {
        Log.d("test", "Logging out...")
        cachedUser.value = AuthResource.NotAuthenticated()
    }

    fun getAuthUser() = cachedUser

}