package com.example.justmanga.data.mapper.chapter.response

import com.example.justmanga.data.dto.chapter.response.JMChapterResponseDto
import com.example.justmanga.data.mapper.JMBaseMapper
import com.example.justmanga.domain.model.chapter.response.JMChapterResponse
import retrofit2.Response

class JMChapterResponseMapper : JMBaseMapper<Response<JMChapterResponseDto>, JMChapterResponse> {
    override fun mapToModel(dto: Response<JMChapterResponseDto>): JMChapterResponse {
        return with(dto.body()){
            JMChapterResponse(this!!.data.sortedWith(compareBy { it.attributes.chapter }), limit, offset, response, result, total)
        }
    }
}