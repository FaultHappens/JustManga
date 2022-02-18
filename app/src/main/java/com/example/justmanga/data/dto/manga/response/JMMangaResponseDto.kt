package com.example.justmanga.data.dto.manga.response

import com.google.gson.annotations.SerializedName

data class JMMangaResponseDto(
    @SerializedName("data")
    val `data`: List<JMMangaModel>,

    @SerializedName("limit")
    val limit: Int,

    @SerializedName("offset")
    val offset: Int,

    @SerializedName("response")
    val response: String,

    @SerializedName("result")
    val result: String,

    @SerializedName("total")
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
    val en: String
)

data class AttributesX(
    val description: List<DescriptionX>,
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
    val en: String
)

class AttributesXX

class AttributesXXX