package com.example.justmanga.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.databinding.JmHomePageRvItemCardBinding

class MainScreenHorizontalRVAdapter(private val listener: (Pair<JMMangaModel, String>) -> Unit) :
    RecyclerView.Adapter<MainScreenHorizontalRVAdapter.MangaViewHolder>() {

    private var mangaListWithCovers: List<Pair<JMMangaModel, String>> = listOf()

    class MangaViewHolder(private val binding: JmHomePageRvItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pair<JMMangaModel, String>) {
            val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()

            Glide.with(binding.root)
                .load("https://uploads.mangadex.org/covers/${data.first.id}/${data.second}.256.jpg")
                .placeholder(circularProgressDrawable)
                .centerCrop()
                .into(binding.image)
            binding.text.text = data.first.attributes.title.en
        }
    }

    fun updateList(newMangaListWithCovers: List<Pair<JMMangaModel, String>>) {
        mangaListWithCovers = newMangaListWithCovers
        notifyItemRangeChanged(0, mangaListWithCovers.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(JmHomePageRvItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.itemView.setOnClickListener{listener(mangaListWithCovers[position])}
        holder.bind(mangaListWithCovers[position])
    }

    override fun getItemCount() = mangaListWithCovers.size


}
