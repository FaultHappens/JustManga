package com.example.justmanga.presentation.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.justmanga.R
import com.example.justmanga.databinding.JmHomePageButtonCardBinding

class JMMainScreenButtonsRVAdapter(private val listener: (Pair<Bitmap, String>) -> Unit) : ListAdapter<Pair<Bitmap, String>, JMMainScreenButtonsRVAdapter.ViewHolder>(TaskDiffCallBack()) {

    private lateinit var binding: JmHomePageButtonCardBinding
    private lateinit var dataList: List<Pair<Bitmap, String>>
    class TaskDiffCallBack : DiffUtil.ItemCallback<Pair<Bitmap, String>>() {
        override fun areItemsTheSame(oldItem: Pair<Bitmap, String>, newItem: Pair<Bitmap, String>): Boolean {
            return oldItem.second == newItem.second
        }

        override fun areContentsTheSame(oldItem: Pair<Bitmap, String>, newItem: Pair<Bitmap, String>): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(binding: JmHomePageButtonCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pair<Bitmap, String>, binding: JmHomePageButtonCardBinding) {
            binding.image.setImageResource(R.drawable.jm_main_screen_btns_temp_holder)
            binding.text.text = data.second
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JMMainScreenButtonsRVAdapter.ViewHolder {
        binding = JmHomePageButtonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JMMainScreenButtonsRVAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener(getItem(position)) }
        return holder.bind(getItem(position), binding)
    }
}