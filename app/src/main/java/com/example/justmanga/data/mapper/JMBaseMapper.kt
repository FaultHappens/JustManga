package com.example.justmanga.data.mapper

interface JMBaseMapper<DTO_RESPONSE, MODEL_RESPONSE> {
    fun mapToModel(dto: DTO_RESPONSE): MODEL_RESPONSE
}