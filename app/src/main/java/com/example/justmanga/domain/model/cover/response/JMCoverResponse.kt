package com.example.justmanga.domain.model.cover.response

import com.example.justmanga.data.dto.cover.response.JMCoverModel
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.google.gson.annotations.SerializedName

data class JMCoverResponse (
    @SerializedName("data")
    val `data`: JMCoverModel,

    @SerializedName("response")
    val response: String,

    @SerializedName("result")
    val result: String,

)