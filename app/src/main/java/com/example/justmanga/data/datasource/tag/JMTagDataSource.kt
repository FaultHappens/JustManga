package com.example.justmanga.data.datasource.tag

import com.example.justmanga.data.dto.tag.response.JMTagResponseDto
import retrofit2.Response

interface JMTagDataSource {
    suspend fun getAllTag(): Response<JMTagResponseDto>
}