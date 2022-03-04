package com.example.justmanga.presentation.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.domain.model.manga_with_cover.JMMangaWithCoverModel
import com.example.justmanga.domain.repository.cover.JMCoverRepository
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import kotlinx.coroutines.launch

class JMDashboardHomePageVM(
    private val jmMangaRepository: JMMangaRepository,
    private val jmCoverRepository: JMCoverRepository
) : ViewModel(){
    private var popularMangaListWithCovers: MutableList<JMMangaWithCoverModel> = mutableListOf()
    private var recentMangaListWithCovers: MutableList<JMMangaWithCoverModel> = mutableListOf()
    private var newMangaListWithCovers: MutableList<JMMangaWithCoverModel> = mutableListOf()

    val popularMangaListLiveData: MutableLiveData<List<JMMangaWithCoverModel>> by lazy {
        MutableLiveData<List<JMMangaWithCoverModel>>()
    }
    val recentMangaListLiveData: MutableLiveData<List<JMMangaWithCoverModel>> by lazy {
        MutableLiveData<List<JMMangaWithCoverModel>>()
    }
    val newMangaListLiveData: MutableLiveData<List<JMMangaWithCoverModel>> by lazy {
        MutableLiveData<List<JMMangaWithCoverModel>>()
    }

    fun updatePopularMangaList(){
        viewModelScope.launch {

            popularMangaListWithCovers.clear()
            val response = jmMangaRepository.getAllManga()
            for(i in response.data){
                var coverId: String = "noCover"
                i.relationships.forEach {
                    if(it.type == "cover_art"){
                        coverId = it.id
                    }
                }
                popularMangaListWithCovers.add(JMMangaWithCoverModel(i, jmCoverRepository.getCover(coverId)))
            }
            popularMangaListLiveData.value = popularMangaListWithCovers
        }
    }

    fun updateRecentMangaList(){
        viewModelScope.launch {
            recentMangaListWithCovers.clear()
            val response = jmMangaRepository.getAllManga()
            for(i in response.data){
                var coverId: String = "noCover"
                i.relationships.forEach {
                    if(it.type == "cover_art"){
                        coverId = it.id
                    }
                }
                recentMangaListWithCovers.add(JMMangaWithCoverModel(i, jmCoverRepository.getCover(coverId)))
            }
            recentMangaListLiveData.value = recentMangaListWithCovers
        }
    }

    fun updateNewMangaList(){
        viewModelScope.launch {
            newMangaListWithCovers.clear()
            val response = jmMangaRepository.getAllManga()
            for(i in response.data){
                var coverId: String = "noCover"
                i.relationships.forEach {
                    if(it.type == "cover_art"){
                        coverId = it.id
                    }
                }
                newMangaListWithCovers.add(JMMangaWithCoverModel(i, jmCoverRepository.getCover(coverId)))
            }
            newMangaListLiveData.value = newMangaListWithCovers
        }
    }


//    fun getRandomManga(): JMMangaModel{
//
//    }
}