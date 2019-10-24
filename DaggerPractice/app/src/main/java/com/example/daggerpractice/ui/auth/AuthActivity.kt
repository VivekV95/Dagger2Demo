package com.example.daggerpractice.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.example.daggerpractice.R
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelProviderFactory: ViewModelFactory

    lateinit var viewModel: AuthViewModel

    @Inject
    @JvmField
    var logo: Drawable? = null

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AuthViewModel::class.java)
        subscribeObservers()
        setClickLsteners()

        setLogo()
    }

    fun setLogo() {
        requestManager
            .load(logo)
            .into(login_logo)
    }

    fun setClickLsteners() {
        login_button.setOnClickListener {
            attemptLogin()
        }
    }

    fun subscribeObservers() {
        viewModel.observeUser().observe(this, Observer {
            it?.let {
                Log.d("test", "onChanged: ${it.email}")
            }
        })
    }
    fun attemptLogin() {
        if (!user_id_input.text.toString().isNullOrEmpty())
            viewModel.authenticateWithId(user_id_input.text.toString().toInt())
    }

}

