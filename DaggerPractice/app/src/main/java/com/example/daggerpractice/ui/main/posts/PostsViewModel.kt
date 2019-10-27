package com.example.daggerpractice.ui.main.posts

import android.util.Log
import androidx.lifecycle.*
import com.example.daggerpractice.SessionManager
import com.example.daggerpractice.model.AuthResource
import com.example.daggerpractice.model.Post
import com.example.daggerpractice.model.Resource
import com.example.daggerpractice.model.User
import com.example.daggerpractice.network.main.MainApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    val sessionManager: SessionManager,
    val mainApi: MainApi
) : ViewModel() {

    val posts = MediatorLiveData<Resource<List<Post>>>()

    fun observePosts(id: Int): LiveData<Resource<List<Post>>> {
        posts.value = Resource.Loading()

        val source = LiveDataReactiveStreams
            .fromPublisher(
                mainApi.getPostsFromUser(id)
                    .onErrorReturn {
                       listOf(Post(-1))
                    }
                    .map { posts ->
                        if (posts.isNotEmpty() && posts[0].id == -1)
                            Resource.Error("Something went wrong", null)
                        Resource.Success(posts)
                    }
                    .subscribeOn(Schedulers.io())
            )

        posts.addSource(source) { postsResource ->
            posts.value = postsResource
            posts.removeSource(source)
        }
        return posts
    }
}