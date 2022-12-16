package com.example.justmanga.domain.model.chapter.request


data class ChapterRequest(
    var manga: String,
    var limit: String,
    var offset: String,
    var translatedLanguage: List<String>,
//    var chapterOrder: ChapterOrder

)
data class ChapterOrder (
    var chapter: String
    )