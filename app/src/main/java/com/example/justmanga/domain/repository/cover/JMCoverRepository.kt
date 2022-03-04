package com.example.justmanga.domain.repository.cover

interface JMCoverRepository {
    suspend fun getCover(id: String): String
}