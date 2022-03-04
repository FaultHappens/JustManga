package com.example.justmanga.data.datasource.cover

import com.example.justmanga.data.dto.cover.response.JMCoverResponseDto
import retrofit2.Response

interface JMCoverDataSource {
    suspend fun getCover(id: String): Response<JMCoverResponseDto>
}