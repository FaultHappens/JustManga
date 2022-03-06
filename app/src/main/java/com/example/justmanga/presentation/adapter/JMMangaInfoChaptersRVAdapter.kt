package com.example.justmanga.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.databinding.JmChapterCardViewBinding
import java.text.SimpleDateFormat
import java.util.*

class JMMangaInfoChaptersRVAdapter(private val listener: (JMChapterModel) -> Unit) :
    RecyclerView.Adapter<JMMangaInfoChaptersRVAdapter.ChapterViewHolder>() {

    private var chaptersList: List<JMChapterModel> = listOf()

    class ChapterViewHolder(private val binding: JmChapterCardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: JMChapterModel) {
            with(binding){
                //TODO: Use resource string with placeholders
                chapterNameTV.text = data.attributes.title
                chapterNumbTV.text = "Chp. " + data.attributes.chapter
                chapterPagesTV.text = data.attributes.pages.toString() + " Pgs."
                chapterVolumeTV.text = "Vol. " + data.attributes.volume
//                chapterUploadTimeTV.text = calculateUploadTime(data.attributes.publishAt)
            }
        }

        private fun calculateUploadTime(publishAt: String):String {
            var returnString = ""

            val dateFormatter = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault())
            val publishDate: Date = dateFormatter.parse(publishAt)!!
            val currentDate: Date = dateFormatter.parse(Calendar.getInstance().time.toString())!!

            val difference  = currentDate.time - publishDate.time
            returnString += difference
            //TODO: format
            return returnString
        }
    }

    fun updateList(newChaptersList: List<JMChapterModel>){
        chaptersList = newChaptersList
        notifyItemRangeChanged(0, chaptersList.size)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChapterViewHolder {
        return JMMangaInfoChaptersRVAdapter.ChapterViewHolder(
            JmChapterCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: JMMangaInfoChaptersRVAdapter.ChapterViewHolder,
        position: Int
    ) {
        holder.itemView.setOnClickListener{listener(chaptersList[position])}
        holder.bind(chaptersList[position])
    }

    override fun getItemCount(): Int {
        return chaptersList.size
    }
}