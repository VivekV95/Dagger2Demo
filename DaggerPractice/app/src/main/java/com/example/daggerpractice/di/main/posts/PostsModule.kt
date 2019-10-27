package com.example.daggerpractice.di.main.posts

import com.example.daggerpractice.ui.main.posts.PostsRecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class PostsModule {

    @Provides
    fun provideAdapter() = PostsRecyclerAdapter()

}