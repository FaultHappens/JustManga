package com.example.justmanga.domain.repository.chapter

import com.example.justmanga.domain.model.chapter.response.JMChapterResponse

interface JMChapterRepository {
    suspend fun getAllMangaChapters(mangaID: String): JMChapterResponse
}