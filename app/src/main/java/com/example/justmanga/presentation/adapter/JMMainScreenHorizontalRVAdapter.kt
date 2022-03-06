package com.example.justmanga.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.justmanga.databinding.JmHomePageRvItemCardBinding
import com.example.justmanga.domain.model.manga_with_cover.JMMangaWithCoverModel

class JMMainScreenHorizontalRVAdapter(private val listener: (JMMangaWithCoverModel) -> Unit) :
    RecyclerView.Adapter<JMMainScreenHorizontalRVAdapter.MangaViewHolder>() {

    private var mangaListWithCovers: List<JMMangaWithCoverModel> = listOf()

    class MangaViewHolder(private val binding: JmHomePageRvItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: JMMangaWithCoverModel) {
            val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
            circularProgressDrawable.strokeWidth = 20f
            circularProgressDrawable.centerRadius = 100f
            circularProgressDrawable.start()

            Glide.with(binding.root)
                .load("https://uploads.mangadex.org/covers/${data.manga.id}/${data.coverID}.256.jpg")
                .placeholder(circularProgressDrawable)
                .centerCrop()
                .into(binding.image)
            binding.text.text = data.manga.attributes.title.en
        }
    }

    fun updateList(newMangaListWithCovers: List<JMMangaWithCoverModel>) {
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
