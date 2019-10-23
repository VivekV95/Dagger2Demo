package com.example.daggerpractice.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerpractice.network.auth.AuthApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


class AuthViewModel @Inject constructor(authApi: AuthApi) : ViewModel() {

    init {
        authApi.getUser(1)
            .toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user ->
                Log.d("test", "onNext: ${user.email}")
            }, { throwable ->
                Log.d("test", "onError: ${throwable.message}")
            })
    }
}