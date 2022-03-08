package com.example.justmanga.domain.repository.cover

import com.example.justmanga.domain.model.chapter.response.JMChapterResponse

interface JMCoverRepository {
    suspend fun getCover(id: String): String
}