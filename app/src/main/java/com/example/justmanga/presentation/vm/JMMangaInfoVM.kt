package com.example.justmanga.presentation.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.domain.model.manga_with_cover.JMMangaWithCoverModel
import com.example.justmanga.domain.repository.chapter.JMChapterRepository
import com.example.justmanga.domain.repository.cover.JMCoverRepository
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import kotlinx.coroutines.launch

class JMMangaInfoVM(
    private val chapterRepository: JMChapterRepository
) : ViewModel() {

    val mangaChaptersListLiveData: MutableLiveData<List<JMChapterModel>> by lazy {
        MutableLiveData<List<JMChapterModel>>()
    }

    fun updateMangaChaptersList(mangaID: String){
        viewModelScope.launch {
            mangaChaptersListLiveData.value = chapterRepository.getAllMangaChapters(mangaID).data
        }
    }
}