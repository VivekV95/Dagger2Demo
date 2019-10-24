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

    private val authUser = MediatorLiveData<User>()

    fun authenticateWithId(userId: Int) {
        val source = LiveDataReactiveStreams
            .fromPublisher(authApi.getUser(userId)
                .subscribeOn(Schedulers.io())
            )
        authUser.addSource(source) {
            authUser.value = it
            authUser.removeSource(source)
        }
    }

    fun observeUser(): LiveData<User> = authUser

}