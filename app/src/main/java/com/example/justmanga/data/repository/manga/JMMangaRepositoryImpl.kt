package com.example.justmanga.data.repository.manga

import android.util.Log
import com.example.justmanga.data.datasource.manga.JMMangaDataSource
import com.example.justmanga.data.mapper.manga.response.JMMangaResponseMapper
import com.example.justmanga.domain.model.manga.response.JMMangaResponse
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import retrofit2.Response

class JMMangaRepositoryImpl(
    private val mangaDataSource: JMMangaDataSource,
    private val mangaResponseMapper: JMMangaResponseMapper
): JMMangaRepository {
    override suspend fun getAllManga(): JMMangaResponse {
        return mangaResponseMapper.mapToModel(mangaDataSource.getAllManga())
    }

    override suspend fun getRandomManga(): Response<JMMangaResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun searchMangaWithID(ids: List<String>): JMMangaResponse {
        val response = mangaDataSource.searchMangaWithID(ids)
        Log.d("RESPONSE", response.toString())
        return mangaResponseMapper.mapToModel(response)
    }

}