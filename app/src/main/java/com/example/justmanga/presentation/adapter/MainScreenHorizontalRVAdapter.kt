package com.example.justmanga.presentation.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.databinding.JmHomePageRvItemCardBinding

class MainScreenHorizontalRVAdapter(private val listener: (JMMangaModel) -> Unit) : ListAdapter<JMMangaModel, MainScreenHorizontalRVAdapter.ViewHolder>(TaskDiffCallBack()) {

    private lateinit var binding: JmHomePageRvItemCardBinding
    class TaskDiffCallBack : DiffUtil.ItemCallback<JMMangaModel>() {
        override fun areItemsTheSame(oldItem: JMMangaModel, newItem: JMMangaModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: JMMangaModel, newItem: JMMangaModel): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(binding: JmHomePageRvItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: JMMangaModel, binding: JmHomePageRvItemCardBinding) {
//            binding.image.setImageBitmap(data.first)
            binding.text.text = data.attributes.title.en
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenHorizontalRVAdapter.ViewHolder {
        binding = JmHomePageRvItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainScreenHorizontalRVAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener(getItem(position)) }
        return holder.bind(getItem(position), binding)
    }
}