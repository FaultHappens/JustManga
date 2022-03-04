package com.example.justmanga.data.mapper.manga.response

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import com.example.justmanga.data.mapper.JMBaseMapper
import com.example.justmanga.domain.model.manga.response.JMMangaResponse
import retrofit2.Response

class JMMangaResponseMapper : JMBaseMapper<Response<JMMangaResponseDto>, JMMangaResponse> {
    override fun mapToModel(dto: Response<JMMangaResponseDto>): JMMangaResponse {
        return with(dto.body()){
            JMMangaResponse(this!!.data, limit, offset, response, result, total)
        }
    }
}