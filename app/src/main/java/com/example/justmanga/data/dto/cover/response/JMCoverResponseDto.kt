package com.example.justmanga.data.dto.cover.response

data class JMCoverResponseDto(
    val `data`: JMCoverModel,
    val response: String,
    val result: String
)

data class JMCoverModel(
    val attributes: Attributes,
    val id: String,
    val relationships: List<Relationship>,
    val type: String
)

data class Attributes(
    val createdAt: String,
    val description: String,
    val fileName: String,
    val locale: String,
    val updatedAt: String,
    val version: Int,
    val volume: String
)

data class Relationship(
    val attributes: AttributesX,
    val id: String,
    val related: String,
    val type: String
)

class AttributesX