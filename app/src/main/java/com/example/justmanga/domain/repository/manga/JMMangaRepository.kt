package com.example.justmanga.domain.repository.manga

import com.example.justmanga.domain.model.manga.response.JMMangaResponse
import retrofit2.Response

interface JMMangaRepository {
    suspend fun getAllManga(): JMMangaResponse
    suspend fun getRandomManga(): Response<JMMangaResponse>
    suspend fun searchManga(queryMap: Map<String, Any>): JMMangaResponse
}