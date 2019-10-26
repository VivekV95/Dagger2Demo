package com.example.daggerpractice.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.daggerpractice.SessionManager
import com.example.daggerpractice.ui.auth.AuthActivity
import com.example.daggerpractice.ui.auth.AuthResource
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        sessionManager.getAuthUser().observe(this, Observer { authResource ->
            authResource?.let {
                when (authResource) {
                    is AuthResource.Loading -> {

                    }
                    is AuthResource.Authenticated -> {
                        Log.d("test", "User authenticated: ${authResource.data?.email}")
                    }
                    is AuthResource.Error -> {

                    }
                    is AuthResource.NotAuthenticated -> {
                        navLoginScreen()
                    }
                }
            }
        })
    }

    private fun navLoginScreen() {
        Intent(this, AuthActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }


}