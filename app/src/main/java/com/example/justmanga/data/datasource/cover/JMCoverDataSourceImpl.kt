package com.example.justmanga.data.datasource.cover

import com.example.justmanga.data.apiservice.cover.JMCoverApiService
import com.example.justmanga.data.dto.cover.response.JMCoverResponseDto
import retrofit2.Response

class JMCoverDataSourceImpl(
    private val coverApiService: JMCoverApiService
): JMCoverDataSource {
    override suspend fun getCover(id: String): Response<JMCoverResponseDto> {
        return coverApiService.getCover(id)
    }

}