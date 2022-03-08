package com.example.justmanga.data.repository.cover

import com.example.justmanga.data.datasource.cover.JMCoverDataSource
import com.example.justmanga.data.mapper.cover.response.JMCoverResponseMapper
import com.example.justmanga.domain.repository.cover.JMCoverRepository

class JMCoverRepositoryImpl(
    private val coverDataSource: JMCoverDataSource,
    private val coverResponseMapper: JMCoverResponseMapper
):  JMCoverRepository {
    override suspend fun getCover(id: String): String {
        val response =  coverDataSource.getCover(id)
        return coverResponseMapper.mapToModel(response).data.attributes.fileName
    }
}