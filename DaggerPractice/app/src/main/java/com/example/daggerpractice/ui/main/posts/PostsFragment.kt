package com.example.daggerpractice.ui.main.posts


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerpractice.R
import com.example.daggerpractice.model.Resource
import com.example.daggerpractice.ui.main.MainActivity
import com.example.daggerpractice.ui.main.MainViewModel
import com.example.daggerpractice.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class PostsFragment : Fragment() {

    private val postsComponent by lazy {
        (activity as MainActivity)
            .mainComponent
            .postsComponent()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: PostsViewModel

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var postsRecyclerAdapter: PostsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        postsComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

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
        initRecyclerView()
    }

    private fun subscribeObservers() {
        mainViewModel.observeAuthState().removeObservers(viewLifecycleOwner)

        activity?.let { activity ->
            mainViewModel.observeAuthState().observe(activity, Observer { authResource ->
                    mainViewModel.id?.let { id ->
                        viewModel.observePosts(id).removeObservers(viewLifecycleOwner)
                        viewModel.observePosts(id)
                            .observe(viewLifecycleOwner, Observer { listResource ->
                                when (listResource){
                                    is Resource.Loading -> {
                                        Log.d("test", "Loading")
                                    }
                                    is Resource.Success -> {
                                        listResource.data?.let {postsRecyclerAdapter.setPosts(it)}
                                    }
                                    is Resource.Error -> {
                                        Log.e("test", "Error")
                                    }
                                }
                            })
                    }
            })
        }
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = postsRecyclerAdapter
        }
    }


}
