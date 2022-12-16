package com.example.justmanga.data.apiservice.chapter_images

import com.example.justmanga.data.dto.chapter_images.response.JMChapterImagesResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JMChapterImagesApiService {
    @GET("at-home/server/{id}")
    suspend fun getChapterImages(
        @Path("id") id: String
    ): Response<JMChapterImagesResponseDto>
}