package com.example.justmanga.data.apiservice.tag

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import com.example.justmanga.data.dto.tag.response.JMTagResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JMTagApiService {
    @GET("manga/tag")
    suspend fun getAllTag(): Response<JMTagResponseDto>
}