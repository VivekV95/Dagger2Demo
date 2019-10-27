package com.example.daggerpractice.di.main.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerpractice.di.ViewModelKey
import com.example.daggerpractice.di.scope.AuthScope
import com.example.daggerpractice.di.scope.PostsScope
import com.example.daggerpractice.ui.main.posts.PostsViewModel
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PostsViewModelModule  {

    @PostsScope
    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel

    @PostsScope
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}