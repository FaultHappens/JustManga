package com.example.justmanga.data.mapper.tag.response

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import com.example.justmanga.data.dto.tag.response.JMTagModel
import com.example.justmanga.data.dto.tag.response.JMTagResponseDto
import com.example.justmanga.data.mapper.JMBaseMapper
import com.example.justmanga.domain.model.manga.response.JMMangaResponse
import com.example.justmanga.domain.model.tag.response.JMTagResponse
import retrofit2.Response

class JMTagResponseMapper: JMBaseMapper<Response<JMTagResponseDto>, JMTagResponse> {
    override fun mapToModel(dto: Response<JMTagResponseDto>): JMTagResponse {
        return with(dto.body()){
            JMTagResponse(this!!.data, limit, offset, response, result, total)
        }
    }

}