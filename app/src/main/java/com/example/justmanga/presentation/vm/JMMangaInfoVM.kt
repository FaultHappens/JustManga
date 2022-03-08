package com.example.justmanga.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.domain.repository.chapter.JMChapterRepository
import kotlinx.coroutines.launch

class JMMangaInfoVM(
    private val chapterRepository: JMChapterRepository
) : ViewModel() {

    lateinit var mangaChaptersListLiveData: LiveData<PagingData<JMChapterModel>>

    fun updateMangaChaptersList(mangaID: String){
        viewModelScope.launch {
            mangaChaptersListLiveData = chapterRepository.getAllMangaChapters(mangaID).cachedIn(viewModelScope)
        }
    }
}