package com.example.justmanga.data.dto.chapter.response

import com.google.gson.annotations.SerializedName

data class JMChapterResponseDto(
    @SerializedName("data")
    val data: List<JMChapterModel>,

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

data class JMChapterModel(
    val attributes: Attributes,
    val id: String,
    val relationships: List<Relationship>,
    val type: String
)

data class Attributes(
    val chapter: String,
    val createdAt: String,
    val externalUrl: Any,
    val pages: Int,
    val publishAt: String,
    val readableAt: String,
    val title: String,
    val translatedLanguage: String,
    val updatedAt: String,
    val version: Int,
    val volume: String
)

data class Relationship(
    val id: String,
    val type: String
)