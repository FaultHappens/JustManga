package com.example.justmanga.data.datasource.chapter

import com.example.justmanga.data.apiservice.chapter.JMChapterApiService
import com.example.justmanga.data.apiservice.manga.JMMangaApiService
import com.example.justmanga.data.datasource.manga.JMMangaDataSource
import com.example.justmanga.data.dto.chapter.response.JMChapterResponseDto
import retrofit2.Response

//class JMChapterDataSourceImpl(
//    private val chapterApiService: JMChapterApiService
//): JMChapterDataSource {
//    override suspend fun getAllMangaChapters(mangaID: String): Response<JMChapterResponseDto> {
//        return chapterApiService.getAllMangaChapters(mangaID)
//    }
//}