package com.example.justmanga.data.mapper.cover.response

import com.example.justmanga.data.dto.cover.response.JMCoverResponseDto
import com.example.justmanga.data.mapper.JMBaseMapper
import com.example.justmanga.domain.model.cover.response.JMCoverResponse
import retrofit2.Response

class JMCoverResponseMapper: JMBaseMapper<Response<JMCoverResponseDto>, JMCoverResponse> {
    override fun mapToModel(dto: Response<JMCoverResponseDto>): JMCoverResponse {
        return with(dto.body()){
            JMCoverResponse(this!!.data, response, result)
        }
    }
}