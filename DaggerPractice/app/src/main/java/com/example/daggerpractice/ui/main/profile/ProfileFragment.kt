package com.example.daggerpractice.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.daggerpractice.R
import com.example.daggerpractice.model.User
import com.example.daggerpractice.ui.auth.AuthResource
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "Profile Fragment", Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory)[ProfileViewModel::class.java]
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.observeAuthState().removeObservers(viewLifecycleOwner)
        viewModel.observeAuthState().observe(this, Observer { authResource ->
            authResource?.let { resource ->
                when (resource) {
                    is AuthResource.Authenticated -> {
                        resource.data?.let { user ->
                            setUserDetails(user)
                        }
                    }
                    is AuthResource.Error -> {
                        resource.message?.let { message ->
                            setErrorDetails(message)
                        }
                    }
                    is AuthResource.Loading -> {

                    }
                    is AuthResource.NotAuthenticated -> {

                    }
                }
            }
        })
    }

    private fun setUserDetails(user: User) {
        email.text = user.email
        username.text = user.username
        website.text = user.website
    }

    private fun setErrorDetails(message: String) {
        email.text = message
        username.text = "error"
        website.text = "error"
    }
}