package com.example.justmanga.domain.repository.chapter_images

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.data.repository.chapter_images.JMChapterImagesRepositoryImpl
import com.example.justmanga.domain.model.chapter_images.response.JMChapterImagesResponse

interface JMChapterImagesRepository {
    suspend fun getChapterImages(chapterId: String): JMChapterImagesResponse
}