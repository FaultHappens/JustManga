package com.example.justmanga.data.apiservice.manga

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface JMMangaApiService {
    @GET("manga")
    suspend fun getAllManga(
    ): Response<JMMangaResponseDto>


    @GET("manga/random")
    suspend fun getRandomManga(): Response<JMMangaResponseDto>


    @GET("manga")
    suspend fun searchMangaWithID(
        @Query("ids[]") ids: List<String>
    ): Response<JMMangaResponseDto>
}