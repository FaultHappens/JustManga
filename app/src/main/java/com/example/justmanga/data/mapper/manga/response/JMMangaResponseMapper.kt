package com.example.justmanga.data.mapper.manga.response

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import com.example.justmanga.data.mapper.JMBaseMapper
import com.example.justmanga.domain.model.manga.response.JMMangaResponse
import retrofit2.Response

class JMMangaResponseMapper : JMBaseMapper<Response<JMMangaResponseDto>, Response<JMMangaResponse>> {
    override fun mapToModel(dto: Response<JMMangaResponseDto>): Response<JMMangaResponse> {
        return dto as Response<JMMangaResponse>
    }
}