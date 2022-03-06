package com.example.justmanga.domain.model.chapter.response

import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.google.gson.annotations.SerializedName

data class JMChapterResponse(
    @SerializedName("data")
    val `data`: List<JMChapterModel>,

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