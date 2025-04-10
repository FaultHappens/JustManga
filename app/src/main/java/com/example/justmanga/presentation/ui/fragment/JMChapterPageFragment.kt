package com.example.justmanga.presentation.ui.fragment

import android.graphics.ColorFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.justmanga.R

class JMChapterPageFragment(
    private val link: String,
    private val chapterHash: String,
    private val clickListener: () -> Unit
): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.jm_chapter_read_page_fragment, container, false)
        view.findViewById<ImageView>(R.id.chapterPageIv).setOnClickListener{clickListener()}
        val circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 20f
        circularProgressDrawable.centerRadius = 100f
        circularProgressDrawable.start()

        Glide.with(view)
            .load("https://uploads.mangadex.org/data/${chapterHash}/${link}")
            .placeholder(circularProgressDrawable)
            .into(view.findViewById(R.id.chapterPageIv))
        return view
    }
}