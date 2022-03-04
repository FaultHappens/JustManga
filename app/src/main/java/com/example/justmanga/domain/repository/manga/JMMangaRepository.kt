package com.example.justmanga.domain.repository.manga

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import com.example.justmanga.domain.model.manga.response.JMMangaResponse
import retrofit2.Response
import retrofit2.http.QueryMap

interface JMMangaRepository {
    suspend fun getAllManga(): JMMangaResponse
    suspend fun getRandomManga(): Response<JMMangaResponse>
    suspend fun searchManga(queryMap: Map<String, Any>): Response<JMMangaResponse>
}