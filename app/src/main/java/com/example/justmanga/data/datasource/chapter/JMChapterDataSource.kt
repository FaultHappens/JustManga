package com.example.justmanga.data.datasource.chapter

import com.example.justmanga.data.dto.chapter.response.JMChapterResponseDto
import retrofit2.Response

interface JMChapterDataSource {
    suspend fun getAllMangaChapters(mangaID: String): Response<JMChapterResponseDto>
}