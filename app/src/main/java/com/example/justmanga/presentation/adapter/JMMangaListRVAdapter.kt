package com.example.justmanga.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.justmanga.databinding.JmMangaListPageCardViewBinding
import com.example.justmanga.domain.model.manga_with_cover.JMMangaWithCoverModel

class JMMangaListRVAdapter(private val listener: (JMMangaWithCoverModel) -> Unit) :
    RecyclerView.Adapter<JMMangaListRVAdapter.MangaViewHolder>() {

    private var mangaListWithCovers: List<JMMangaWithCoverModel> = listOf()

    class MangaViewHolder(private val binding: JmMangaListPageCardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: JMMangaWithCoverModel) {
            with(binding){
                val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
                circularProgressDrawable.strokeWidth = 20f
                circularProgressDrawable.centerRadius = 100f
                circularProgressDrawable.start()

                Glide.with(binding.root)
                    .load("https://uploads.mangadex.org/covers/${data.manga.id}/${data.coverID}.256.jpg")
                    .placeholder(circularProgressDrawable)
                    .centerCrop()
                    .into(mangaImageIV)

                mangaNameTV.text = data.manga.attributes.title.en
                //TODO: read "total" of manga chapters and insert in chaptersNumbTV
                mangaDescriptionTV.text = data.manga.attributes.description.en
                var genresText: String = ""
                for(i in data.manga.attributes.tags){
                    genresText += i.attributes.name.en
                    genresText +=  ", "
                }
                mangaGenresTV.text = genresText


            }
        }
    }

    fun updateList(newMangaListWithCovers: List<JMMangaWithCoverModel>) {
        mangaListWithCovers = newMangaListWithCovers
        notifyItemRangeChanged(0, mangaListWithCovers.size)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JMMangaListRVAdapter.MangaViewHolder {
        return JMMangaListRVAdapter.MangaViewHolder(
            JmMangaListPageCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: JMMangaListRVAdapter.MangaViewHolder, position: Int) {
        holder.itemView.setOnClickListener{listener(mangaListWithCovers[position])}
        holder.bind(mangaListWithCovers[position])
    }

    override fun getItemCount() = mangaListWithCovers.size
}