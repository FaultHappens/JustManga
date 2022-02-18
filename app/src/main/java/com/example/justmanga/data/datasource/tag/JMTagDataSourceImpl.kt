package com.example.justmanga.data.datasource.tag

import com.example.justmanga.data.apiservice.tag.JMTagApiService
import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import com.example.justmanga.data.dto.tag.response.JMTagResponseDto
import retrofit2.Response

class JMTagDataSourceImpl(
    private val tagApiService: JMTagApiService
): JMTagDataSource {
    override suspend fun getAllTag(): Response<JMTagResponseDto> {
        return tagApiService.getAllTag()
    }
}