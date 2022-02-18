package com.example.justmanga.domain.model.manga.response

import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.google.gson.annotations.SerializedName

data class JMMangaResponse(
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