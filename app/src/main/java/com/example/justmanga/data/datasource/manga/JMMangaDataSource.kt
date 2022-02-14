package com.example.justmanga.data.datasource.manga

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import retrofit2.Response

interface JMMangaDataSource {
    suspend fun getAllManga(): Response<JMMangaResponseDto>

    suspend fun searchManga(qeuryMap: Map<String, Any>): Response<JMMangaResponseDto>

    suspend fun getRandomManga(): Response<JMMangaResponseDto>
}