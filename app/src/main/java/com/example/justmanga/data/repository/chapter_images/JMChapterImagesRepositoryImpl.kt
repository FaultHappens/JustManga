package com.example.justmanga.data.repository.chapter_images

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.justmanga.data.apiservice.chapter.JMChapterApiService
import com.example.justmanga.data.apiservice.chapter_images.JMChapterImagesApiService
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.data.mapper.chapter.response.JMChapterResponseMapper
import com.example.justmanga.data.mapper.chapter_images.response.JMChapterImagesResponseMapper
import com.example.justmanga.domain.model.chapter_images.response.JMChapterImagesResponse
import com.example.justmanga.domain.repository.chapter_images.JMChapterImagesRepository

class JMChapterImagesRepositoryImpl(
    private val chapterImagesApiService: JMChapterImagesApiService,
    private val chapterImagesResponseMapper: JMChapterImagesResponseMapper
): JMChapterImagesRepository {
    override suspend fun getChapterImages(chapterId: String): JMChapterImagesResponse {
        return chapterImagesResponseMapper.mapToModel(chapterImagesApiService.getChapterImages(chapterId))
    }
}