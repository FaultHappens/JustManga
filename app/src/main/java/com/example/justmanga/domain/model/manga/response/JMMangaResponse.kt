package com.example.justmanga.domain.model.manga.response

import com.example.justmanga.data.dto.manga.response.JMMangaModel

data class JMMangaResponse(
    val `data`: List<JMMangaModel>,
    val limit: Int,
    val offset: Int,
    val response: String,
    val result: String,
    val total: Int
)