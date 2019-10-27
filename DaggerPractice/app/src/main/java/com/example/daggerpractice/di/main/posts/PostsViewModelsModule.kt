package com.example.daggerpractice.di.main.posts

import androidx.lifecycle.ViewModel
import com.example.daggerpractice.di.ViewModelKey
import com.example.daggerpractice.ui.main.posts.PostsViewModel
import com.example.daggerpractice.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PostsViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel
}