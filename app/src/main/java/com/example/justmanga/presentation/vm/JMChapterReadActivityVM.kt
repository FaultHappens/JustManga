package com.example.justmanga.presentation.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justmanga.domain.model.chapter_images.response.JMChapterImagesResponse
import com.example.justmanga.domain.repository.chapter_images.JMChapterImagesRepository
import kotlinx.coroutines.launch

class JMChapterReadActivityVM(
    private val jmChapterImagesRepository: JMChapterImagesRepository,
) : ViewModel(){
    val chaptersImagesLiveData: MutableLiveData<JMChapterImagesResponse> by lazy {
        MutableLiveData<JMChapterImagesResponse>()
    }

    fun getChaptersImages(chapterId: String){
        viewModelScope.launch {
            chaptersImagesLiveData.value = jmChapterImagesRepository.getChapterImages(chapterId)
        }
    }
}