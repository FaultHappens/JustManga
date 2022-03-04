package com.example.justmanga.data.dto.manga.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

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

class JMMangaModel: Serializable{
    lateinit var attributes: Attributes
    lateinit var id: String
    lateinit var relationships: List<RelationshipX>
    lateinit var type: String
}

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
    val ja: String,
    val ru: String
)

data class Description(
    val en: String,
    val ja: String,
    val ru: String
)

data class Links(
    val al: String,
    val ap: String,
    val bw: String,
    val mu: String,
    val nu: String,
    val kt: String,
    val amz: String,
    val ebj: String,
    val mal: String,
    val cdj: String,
    val raw: String,
    val engtl: String,
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