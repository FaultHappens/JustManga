package com.example.justmanga.data.dto.tag.response

import com.example.justmanga.data.dto.manga.response.Attributes
import com.example.justmanga.data.dto.manga.response.Relationship

data class JMTagResponseDto(
    val `data`: List<tagData>,
    val limit: Int,
    val offset: Int,
    val response: String,
    val result: String,
    val total: Int
)

data class tagData(
    val attributes: tagAttributes,
    val id: String,
    val relationships: List<tagRelationship>,
    val type: String
)

data class tagAttributes(
    val description: List<tagDescription>,
    val group: String,
    val name: tagName,
    val version: Int
)

data class tagRelationship(
    val attributes: tagAttributesX,
    val id: String,
    val related: String,
    val type: String
)

data class tagDescription(
    val property1: String,
    val property2: String
)

data class tagName(
    val en: String
)

class tagAttributesX