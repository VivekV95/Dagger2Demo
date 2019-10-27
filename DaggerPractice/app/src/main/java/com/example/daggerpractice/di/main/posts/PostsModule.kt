package com.example.daggerpractice.di.main.posts

import com.example.daggerpractice.di.scope.PostsScope
import com.example.daggerpractice.ui.main.posts.PostsRecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class PostsModule {

    @PostsScope
    @Provides
    fun provideAdapter() = PostsRecyclerAdapter()

}