package com.example.justmanga.data.repository.chapter

import com.example.justmanga.data.datasource.chapter.JMChapterDataSource
import com.example.justmanga.data.datasource.manga.JMMangaDataSource
import com.example.justmanga.data.mapper.chapter.response.JMChapterResponseMapper
import com.example.justmanga.data.mapper.manga.response.JMMangaResponseMapper
import com.example.justmanga.domain.model.chapter.response.JMChapterResponse
import com.example.justmanga.domain.repository.chapter.JMChapterRepository
import com.example.justmanga.domain.repository.manga.JMMangaRepository

class JMChapterRepositoryImpl(
    private val chapterDataSource: JMChapterDataSource,
    private val chapterResponseMapper: JMChapterResponseMapper
): JMChapterRepository {
    override suspend fun getAllMangaChapters(mangaID: String): JMChapterResponse {
        return chapterResponseMapper.mapToModel(chapterDataSource.getAllMangaChapters(mangaID))
    }
}