package com.example.justmanga.data.datasource.manga

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import retrofit2.Response

interface JMMangaDataSource {
    suspend fun getAllManga(): Response<JMMangaResponseDto>

    suspend fun searchMangaWithID(ids: List<String>): Response<JMMangaResponseDto>

    suspend fun getRandomManga(): Response<JMMangaResponseDto>
}