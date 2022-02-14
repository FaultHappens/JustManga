package com.example.justmanga.presentation.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.justmanga.databinding.MainScreenRvItemCardBinding

class MainScreenHorizontalRVAdapter(private val listener: (Pair<Bitmap, String>) -> Unit) : ListAdapter<Pair<Bitmap, String>, MainScreenHorizontalRVAdapter.ViewHolder>(TaskDiffCallBack()) {

    private lateinit var binding: MainScreenRvItemCardBinding
    class TaskDiffCallBack : DiffUtil.ItemCallback<Pair<Bitmap, String>>() {
        override fun areItemsTheSame(oldItem: Pair<Bitmap, String>, newItem: Pair<Bitmap, String>): Boolean {
            return oldItem.second == newItem.second
        }

        override fun areContentsTheSame(oldItem: Pair<Bitmap, String>, newItem: Pair<Bitmap, String>): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(binding: MainScreenRvItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pair<Bitmap, String>, binding: MainScreenRvItemCardBinding) {
//            binding.image.setImageBitmap(data.first)
            binding.text.text = data.second
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenHorizontalRVAdapter.ViewHolder {
        binding = MainScreenRvItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainScreenHorizontalRVAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener(getItem(position)) }
        return holder.bind(getItem(position), binding)
    }
}