package com.example.daggerpractice.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.daggerpractice.R
import com.example.daggerpractice.ui.auth.AuthActivity
import com.example.daggerpractice.model.AuthResource
import com.example.daggerpractice.ui.main.posts.PostsFragment
import com.example.daggerpractice.viewmodel.ViewModelFactory
import com.google.android.material.navigation.NavigationView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MainViewModel

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_profile -> {
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.main, true)
                    .build()
                Navigation.findNavController(
                    this,
                    R.id.nav_host_fragment_container
                ).navigate(R.id.profileScreen, null, navOptions)
            }
            R.id.nav_posts ->
                if (isValidDestination(R.id.postsScreen))
                    Navigation.findNavController(
                        this,
                        R.id.nav_host_fragment_container
                    ).navigate(R.id.postsScreen)

        }
        menuItem.isChecked = true
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun isValidDestination(destination: Int): Boolean =
        destination != Navigation
            .findNavController(this, R.id.nav_host_fragment_container)
            .currentDestination
            ?.id

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        subscribeObservers()
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                viewModel.logOut()
                return true
            }
            android.R.id.home -> {
                return if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START)
                    true
                } else
                    false

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun subscribeObservers() =
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


    private fun navLoginScreen() =
        Intent(this, AuthActivity::class.java).apply {
            startActivity(this)
            finish()
        }

    private fun init() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)
        NavigationUI.setupWithNavController(nav_view, navController)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI
            .navigateUp(
                Navigation.findNavController(this, R.id.nav_host_fragment_container),
                drawer_layout
            )
    }

}
