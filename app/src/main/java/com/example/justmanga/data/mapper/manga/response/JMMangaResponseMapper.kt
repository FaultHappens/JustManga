package com.example.justmanga.data.mapper.manga.response

import com.example.justmanga.data.dto.manga.response.JMMangaResponseDto
import com.example.justmanga.data.mapper.JMBaseMapper
import com.example.justmanga.domain.model.manga.response.JMMangaResponse

class JMMangaResponseMapper: JMBaseMapper<JMMangaResponseDto, JMMangaResponse> {
    override fun mapToModel(dto: JMMangaResponseDto): JMMangaResponse =
        with(dto){
            JMMangaResponse(
                data = mapToModels(data), limit, offset, response, result, total
            )
        }

    private fun mapToModels(data: List<JMMangaModel>): List<JMMangaModel> {
        val models = mutableListOf<ISCompanyProfileContent>()
    }

}