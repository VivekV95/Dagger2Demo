package com.example.daggerpractice.ui.main.posts


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.daggerpractice.R
import com.example.daggerpractice.model.AuthResource
import com.example.daggerpractice.ui.main.MainViewModel
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class PostsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: PostsViewModel

    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory)[PostsViewModel::class.java]
        activity?.let {
            mainViewModel = ViewModelProviders.of(it, viewModelFactory)[MainViewModel::class.java]
        }
        subscribeObservers()
    }

    private fun subscribeObservers() {
        mainViewModel.observeAuthState().removeObservers(viewLifecycleOwner)

        activity?.let { activity ->
            mainViewModel.observeAuthState().observe(activity, Observer { authResource ->
                    mainViewModel.id?.let { id ->
                        viewModel.observePosts(id).removeObservers(viewLifecycleOwner)
                        viewModel.observePosts(id)
                            .observe(viewLifecycleOwner, Observer { listResource ->
                                listResource.data?.let {
                                    val i = 0
                                }
                            })
                    }
            })
        }
    }


}
