package com.example.daggerpractice.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.daggerpractice.model.User
import com.example.daggerpractice.network.auth.AuthApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


class AuthViewModel @Inject constructor(val authApi: AuthApi) : ViewModel() {

    private val authUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithId(userId: Int) {
        authUser.value = AuthResource.Loading()

        val source = LiveDataReactiveStreams
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
        authUser.addSource(source) {user ->
            authUser.value = user
            authUser.removeSource(source)
        }
    }

    fun observeUser(): LiveData<AuthResource<User>> = authUser

}