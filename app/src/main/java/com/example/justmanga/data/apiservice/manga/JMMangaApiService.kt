package com.example.justmanga.data.apiservice.manga

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface JMMangaApiService {
    @GET("manga")
    suspend fun getAllManga(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10
    ): Response<JMMangaResponseDto>


    @GET("manga/random")
    suspend fun getRandomManga(): Response<JMMangaResponseDto>


    @GET("manga")
    suspend fun searchManga(
        @QueryMap() queryMap: Map<String, Any>
    ): Response<JMMangaResponseDto>
}