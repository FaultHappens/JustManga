package com.example.justmanga.domain.model.tag.response

import com.example.justmanga.data.dto.tag.response.JMTagModel

data class JMTagResponse (
    val `data`: List<JMTagModel>,
    val limit: Int,
    val offset: Int,
    val response: String,
    val result: String,
    val total: Int
)