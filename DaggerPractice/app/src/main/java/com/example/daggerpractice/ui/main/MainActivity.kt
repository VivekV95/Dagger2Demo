package com.example.daggerpractice.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.daggerpractice.R
import com.example.daggerpractice.ui.auth.AuthActivity
import com.example.daggerpractice.model.AuthResource
import com.example.daggerpractice.ui.main.posts.PostsFragment
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        subscribeObservers()
        testFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.logout -> {
                viewModel.logOut()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun testFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, PostsFragment())
            .commit()
    }

    private fun subscribeObservers() {
        viewModel.observeAuthState().observe(this, Observer { authResource ->
            authResource?.let {
                when (it) {
                    is AuthResource.Loading -> {
                        viewModel.id = null
                    }
                    is AuthResource.Authenticated -> {
                        Log.d("test", "User authenticated: ${authResource.data?.email}")
                        viewModel.id = it.data?.id
                    }
                    is AuthResource.Error -> {
                        viewModel.id = null
                    }
                    is AuthResource.NotAuthenticated -> {
                        viewModel.id = null
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
