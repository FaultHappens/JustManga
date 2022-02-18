package com.example.justmanga.data.datasource.manga

import android.util.Log
import com.example.justmanga.data.apiservice.manga.JMMangaApiService
import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import retrofit2.Response

class JMMangaDataSourceImpl(
    private val mangaApiService: JMMangaApiService
    ): JMMangaDataSource {
    override suspend fun getAllManga(): Response<JMMangaResponseDto> {
        Log.d("awdawdawd", mangaApiService.getAllManga().toString())
        return mangaApiService.getAllManga()
    }

    override suspend fun searchManga(queryMap: Map<String, Any>): Response<JMMangaResponseDto> {
        return mangaApiService.searchManga(queryMap)
    }

    override suspend fun getRandomManga(): Response<JMMangaResponseDto> {
        return mangaApiService.getRandomManga()
    }
}