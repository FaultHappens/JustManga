package com.example.justmanga.data.dto.manga.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class JMMangaResponseDto(
    @SerializedName("data")
    val data: List<JMMangaModel>,

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

@Parcelize
data class JMMangaModel(
    val attributes: Attributes,
    val id: String,
    val relationships: List<RelationshipX>,
    val type: String
): Parcelable

@Parcelize
data class Attributes(
    val altTitles: List<Map<String?, String?>>?,
    val createdAt: String?,
    val description: Map<String?, String?>?,
    val lastChapter: String?,
    val lastVolume: String?,
    val links: Map<String?, String?>?,
    val originalLanguage: String?,
    val state: String?,
    val status: String?,
    val tags: List<Tag>?,
    val title: Map<String?, String?>,
    val updatedAt: String?,
    val year: Int?
): Parcelable

@Parcelize
data class RelationshipX(
    val id: String?,
    val related: String?,
    val type: String?
): Parcelable


@Parcelize
data class Tag(
    val attributes: AttributesX?,
    val id: String?,
    val relationships: List<Relationship>?,
    val type: String?
): Parcelable

@Parcelize
data class AttributesX(
    val description: List<DescriptionX>?,
    val group: String?,
    val name: Map<String?, String?>,
    val version: Int?
): Parcelable

@Parcelize
data class Relationship(
    val id: String?,
    val related: String?,
    val type: String?
): Parcelable

@Parcelize
data class DescriptionX(
    val property1: String?,
    val property2: String?
): Parcelable
