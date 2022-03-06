package com.example.justmanga.domain.repository.chapter

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.justmanga.data.dto.chapter.response.JMChapterModel

interface JMChapterRepository {
    suspend fun getAllMangaChapters(mangaID: String): LiveData<PagingData<JMChapterModel>>
}