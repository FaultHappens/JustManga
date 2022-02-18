package com.example.justmanga.domain.model.tag.response

import com.example.justmanga.data.dto.tag.response.tagData

data class JMTagResponse (
    val `data`: List<tagData>,
    val limit: Int,
    val offset: Int,
    val response: String,
    val result: String,
    val total: Int
)