package com.example.justmanga.data.datasource.manga

import android.util.Log
import com.example.justmanga.data.apiservice.manga.JMMangaApiService
import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import retrofit2.Response

class JMMangaDataSourceImpl(
    private val mangaApiService: JMMangaApiService
    ): JMMangaDataSource {
    override suspend fun getAllManga(): Response<JMMangaResponseDto> {
        return mangaApiService.getAllManga()
    }

    override suspend fun searchMangaWithID(ids: List<String>): Response<JMMangaResponseDto> {
        return mangaApiService.searchMangaWithID(ids)
    }

    override suspend fun getRandomManga(): Response<JMMangaResponseDto> {
        return mangaApiService.getRandomManga()
    }
}