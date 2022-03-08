package com.example.justmanga.data.apiservice.chapter

import com.example.justmanga.data.dto.chapter.response.JMChapterResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//TODO: Add order param with Order class in to order chapters
interface JMChapterApiService {
    @GET("chapter")
    suspend fun getAllMangaChapters(
        @Query("manga") mangaID: String,
        @Query("limit") limit: String,
        @Query("offset") offset: String,
//        @Query("order") order: Order
    ): Response<JMChapterResponseDto>
}
