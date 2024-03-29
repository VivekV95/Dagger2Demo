package com.example.daggerpractice.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.daggerpractice.SessionManager
import com.example.daggerpractice.model.AuthResource
import com.example.daggerpractice.model.User
import com.example.daggerpractice.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthViewModel @Inject constructor(private val authApi: AuthApi, private val sessionManager: SessionManager) :
    ViewModel() {

    fun authenticateWithId(userId: Int) {
        sessionManager.authenticateWithId(queryUserId(userId))
    }

    private fun queryUserId(userId: Int) =
        LiveDataReactiveStreams
            .fromPublisher(authApi.getUser(userId)
                .onErrorReturn {
                    User(-1)
                }
                .map<AuthResource<User>> { user ->
                    if (user.id == -1)
                        AuthResource.Error("Could not authenticate", null)
                    else
                        AuthResource.Authenticated(user)
                }
                .subscribeOn(Schedulers.io())
            )

    fun observeAuthState(): LiveData<AuthResource<User>> = sessionManager.getAuthUser()

}