package com.example.justmanga.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.databinding.JmChapterCardViewBinding
import java.text.SimpleDateFormat
import java.util.*

class JMMangaInfoChaptersRVAdapter(private val listener: (JMChapterModel) -> Unit) :
    PagingDataAdapter<JMChapterModel, JMMangaInfoChaptersRVAdapter.ChapterViewHolder>(DiffUtilCallBack) {

    object DiffUtilCallBack : DiffUtil.ItemCallback<JMChapterModel>() {
        override fun areItemsTheSame(oldItem: JMChapterModel, newItem: JMChapterModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JMChapterModel, newItem: JMChapterModel): Boolean {
            return oldItem == newItem
        }
    }

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

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.itemView.setOnClickListener{listener(getItem(position)!!)}
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        return ChapterViewHolder(
            JmChapterCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


}