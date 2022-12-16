package com.example.justmanga.data.apiservice.chapter

import androidx.room.Index
import com.example.justmanga.data.dto.chapter.response.JMChapterResponseDto
import com.example.justmanga.domain.model.chapter.request.ChapterOrder
import com.example.justmanga.domain.model.chapter.request.ChapterRequest
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.GET
import retrofit2.http.Query

//TODO: Add order param with Order class to order chapters
interface JMChapterApiService {
    @GET("chapter")
    suspend fun getAllMangaChapters(
        @Query("offset") offset: String,
        @Query("limit") limit: String,
        @Query("manga") manga: String,
        @Query("translatedLanguage[]") translatedLanguage: List<String>,
        @Body order: ChapterOrder
    ): Response<JMChapterResponseDto>
}
