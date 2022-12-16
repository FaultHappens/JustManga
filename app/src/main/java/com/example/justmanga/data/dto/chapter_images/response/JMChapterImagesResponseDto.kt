package com.example.justmanga.data.dto.chapter_images.response

import com.google.gson.annotations.SerializedName

data class JMChapterImagesResponseDto (
    @SerializedName("chapter")
    val chapter: Chapter?
    )

data class Chapter(
    @SerializedName("hash")
    val hash: String,
    @SerializedName("data")
    val data: List<String>
)