package com.example.justmanga.data.mapper.chapter_images.response

import com.example.justmanga.data.dto.chapter_images.response.JMChapterImagesResponseDto
import com.example.justmanga.data.mapper.JMBaseMapper
import com.example.justmanga.domain.model.chapter_images.response.JMChapterImagesResponse
import retrofit2.Response

class JMChapterImagesResponseMapper :
    JMBaseMapper<Response<JMChapterImagesResponseDto>, JMChapterImagesResponse> {
    override fun mapToModel(dto: Response<JMChapterImagesResponseDto>): JMChapterImagesResponse {
        return with(dto.body()) {
            JMChapterImagesResponse(this!!.chapter!!)
        }
    }
}