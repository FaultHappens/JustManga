package com.example.justmanga.data.dto.tag.response

import com.example.justmanga.data.dto.manga.response.Attributes
import com.example.justmanga.data.dto.manga.response.Relationship

data class JMMangaTagModelsResponse(
    val `data`: List<JMMangaTagModel>,
    val limit: Int,
    val offset: Int,
    val response: String,
    val result: String,
    val total: Int
)

data class JMMangaTagModel(
    val attributes: Attributes,
    val id: String,
    val relationships: List<Relationship>,
    val type: String
)