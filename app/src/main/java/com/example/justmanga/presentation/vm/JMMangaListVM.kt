package com.example.justmanga.presentation.vm

import androidx.lifecycle.ViewModel
import com.example.justmanga.domain.repository.chapter.JMChapterRepository
import com.example.justmanga.domain.repository.manga.JMMangaRepository

class JMMangaListVM(
    private val mangaRepository: JMMangaRepository
) : ViewModel() {
}