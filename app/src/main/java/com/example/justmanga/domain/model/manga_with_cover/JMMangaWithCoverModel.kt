package com.example.justmanga.domain.model.manga_with_cover

import android.os.Parcelable
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class JMMangaWithCoverModel(
    val manga: JMMangaModel,
    val coverID: String
): Parcelable