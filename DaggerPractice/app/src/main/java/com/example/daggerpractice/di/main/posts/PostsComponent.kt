package com.example.daggerpractice.di.main.posts

import com.example.daggerpractice.di.scope.PostsScope
import com.example.daggerpractice.ui.main.posts.PostsFragment
import dagger.Subcomponent

@PostsScope
@Subcomponent(
    modules = [
        PostsModule::class,
        PostsViewModelModule::class]
)
interface PostsComponent {

    fun inject(fragment: PostsFragment)
}