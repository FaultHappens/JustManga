package com.example.justmanga.data.repository.chapter

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.justmanga.data.apiservice.chapter.JMChapterApiService
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.data.mapper.chapter.response.JMChapterResponseMapper
import com.example.justmanga.data.pagingsource.chapter.JMChapterPagingSource
import com.example.justmanga.data.pagingsource.chapter.JMChapterPagingSource.Companion.NETWORK_PAGE_SIZE
import com.example.justmanga.domain.repository.chapter.JMChapterRepository

class JMChapterRepositoryImpl(
    private val chapterApiService: JMChapterApiService,
    private val chapterResponseMapper: JMChapterResponseMapper
): JMChapterRepository {
    override suspend fun getAllMangaChapters(mangaID: String): LiveData<PagingData<JMChapterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                JMChapterPagingSource(chapterApiService, chapterResponseMapper, mangaID)
            }
        ).liveData
    }
}