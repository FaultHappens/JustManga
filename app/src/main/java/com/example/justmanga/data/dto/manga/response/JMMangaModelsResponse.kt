package com.example.justmanga.data.dto.manga.response

data class JMMangaModelsResponse(
    val `data`: List<JMMangaModel>,
    val limit: Int,
    val offset: Int,
    val response: String,
    val result: String,
    val total: Int
)

data class JMMangaModel(
    val attributes: Attributes,
    val id: String,
    val relationships: List<RelationshipX>,
    val type: String
)

data class Attributes(
    val altTitles: List<AltTitle>,
    val chapterNumbersResetOnNewVolume: Boolean,
    val contentRating: String,
    val createdAt: String,
    val description: Description,
    val isLocked: Boolean,
    val lastChapter: String,
    val lastVolume: String,
    val links: Links,
    val originalLanguage: String,
    val publicationDemographic: String,
    val state: String,
    val status: String,
    val tags: List<Tag>,
    val title: Title,
    val updatedAt: String,
    val version: Int,
    val year: Int
)

data class RelationshipX(
    val attributes: AttributesXXX,
    val id: String,
    val related: String,
    val type: String
)

data class AltTitle(
    val property1: String,
    val property2: String
)

data class Description(
    val property1: String,
    val property2: String
)

data class Links(
    val property1: String,
    val property2: String
)

data class Tag(
    val attributes: AttributesX,
    val id: String,
    val relationships: List<Relationship>,
    val type: String
)

data class Title(
    val property1: String,
    val property2: String
)

data class AttributesX(
    val description: DescriptionX,
    val group: String,
    val name: Name,
    val version: Int
)

data class Relationship(
    val attributes: AttributesXX,
    val id: String,
    val related: String,
    val type: String
)

data class DescriptionX(
    val property1: String,
    val property2: String
)

data class Name(
    val property1: String,
    val property2: String
)

class AttributesXX

class AttributesXXX