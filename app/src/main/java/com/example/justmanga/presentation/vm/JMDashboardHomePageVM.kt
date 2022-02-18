package com.example.justmanga.presentation.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import kotlinx.coroutines.launch

class JMDashboardHomePageVM(
    private val jmMangaRepository: JMMangaRepository
) : ViewModel(){
    val mangaListLiveData: MutableLiveData<List<JMMangaModel>> by lazy {
        MutableLiveData<List<JMMangaModel>>()
    }

    fun updateMangaList(){
        viewModelScope.launch {
            val response = jmMangaRepository.getAllManga()
            Log.d("awdawdawd", response.body().toString())
//            mangaListLiveData.value = response.body()?.data
        }
    }


//    fun getRandomManga(): JMMangaModel{
//
//    }
}