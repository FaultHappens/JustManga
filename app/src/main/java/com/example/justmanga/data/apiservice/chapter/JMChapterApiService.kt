package com.example.justmanga.data.apiservice.chapter

import com.example.justmanga.data.dto.chapter.response.JMChapterResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JMChapterApiService {
    @GET("chapter")
    suspend fun getAllMangaChapters(@Query("manga") mangaID: String): Response<JMChapterResponseDto>
}