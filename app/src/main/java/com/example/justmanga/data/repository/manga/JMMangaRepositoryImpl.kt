package com.example.justmanga.data.repository.manga

import com.example.justmanga.data.datasource.manga.JMMangaDataSource
import com.example.justmanga.data.mapper.manga.response.JMMangaResponseMapper
import com.example.justmanga.domain.model.manga.response.JMMangaResponse
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import retrofit2.Response

class JMMangaRepositoryImpl(
    private val mangaDataSource: JMMangaDataSource,
    private val mangaResponseMapper: JMMangaResponseMapper
): JMMangaRepository {
    override suspend fun getAllManga(): Response<JMMangaResponse> {
        return mangaResponseMapper.mapToModel(mangaDataSource.getAllManga().result)
    }

    override suspend fun getRandomManga(): Response<JMMangaResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun searchManga(queryMap: Map<String, Any>): Response<JMMangaResponse> {
        TODO("Not yet implemented")
    }

}