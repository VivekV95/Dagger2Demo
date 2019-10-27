package com.example.daggerpractice.ui.main.posts

import com.example.daggerpractice.model.Post
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daggerpractice.R


class PostsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var posts: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_post_list_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).bind(posts[position])
    }

    override fun getItemCount() = posts.size

    fun setPosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<TextView>(R.id.title)

        fun bind(post: Post) {
            title.text = post.title
        }
    }
}