package com.example.justmanga.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.justmanga.data.dto.tag.response.JMTagModel
import com.example.justmanga.databinding.JmSearchTagCardBinding

class JMSearchScreenTagsRVAdapter(
    private val listener: (JMTagModel) -> Unit
) : RecyclerView.Adapter<JMSearchScreenTagsRVAdapter.TagViewHolder>() {


    private var tagList: List<JMTagModel> = listOf()

    fun updateList(newTagsList: List<JMTagModel>) {
        tagList = newTagsList
        notifyDataSetChanged()
    }

    class TagViewHolder(private val binding: JmSearchTagCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: JMTagModel) {
            binding.tagText.text = data.attributes.name.en
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return JMSearchScreenTagsRVAdapter.TagViewHolder(
            JmSearchTagCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.itemView.setOnClickListener{listener(tagList[position])}
        holder.bind(tagList[position])
    }

    override fun getItemCount(): Int {
        return tagList.size
    }
}
