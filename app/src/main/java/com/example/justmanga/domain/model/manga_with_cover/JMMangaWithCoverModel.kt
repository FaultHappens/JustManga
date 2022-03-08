package com.example.justmanga.domain.model.manga_with_cover

import com.example.justmanga.data.dto.manga.response.JMMangaModel
import java.io.Serializable

class JMMangaWithCoverModel(manga: JMMangaModel, coverID: String): Serializable {
    val manga: JMMangaModel = manga
    val coverID: String = coverID
}