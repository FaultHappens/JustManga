package com.example.justmanga.domain.repository.tag

import com.example.justmanga.domain.model.tag.response.JMTagResponse
import retrofit2.Response

interface JMTagRepository {
    suspend fun getAllTag(): JMTagResponse
}