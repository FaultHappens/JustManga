package com.example.justmanga.data.repository.tag

import com.example.justmanga.data.datasource.tag.JMTagDataSource
import com.example.justmanga.data.mapper.tag.response.JMTagResponseMapper
import com.example.justmanga.domain.model.tag.response.JMTagResponse
import com.example.justmanga.domain.repository.tag.JMTagRepository
import retrofit2.Response

class JMTagRepositoryImpl(
    private val tagDataSource: JMTagDataSource,
    private val tagResponseMapper: JMTagResponseMapper
): JMTagRepository {
    override suspend fun getAllTag(): JMTagResponse {
        return tagResponseMapper.mapToModel(tagDataSource.getAllTag())
    }

}