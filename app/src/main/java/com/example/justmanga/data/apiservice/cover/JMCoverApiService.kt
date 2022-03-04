package com.example.justmanga.data.apiservice.cover

import com.example.justmanga.data.dto.cover.response.JMCoverResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JMCoverApiService {
    @GET("cover/{id}")
    suspend fun getCover(@Path("id") id: String): Response<JMCoverResponseDto>
}