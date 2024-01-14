package com.example.greenkim

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greenkim.databinding.RecyclerviewItemBinding
import java.text.SimpleDateFormat


class PostsAdapter : RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<posts>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val post = listData.get(position)
        holder.setPost(post)
    }
}

class Holder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setPost(post:posts) {

        binding.nickName.text = "아기자기"
        binding.chatCounts.text = "${post.no}"


    }
}