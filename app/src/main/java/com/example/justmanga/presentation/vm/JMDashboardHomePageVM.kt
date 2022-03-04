package com.example.justmanga.presentation.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.domain.repository.cover.JMCoverRepository
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import kotlinx.coroutines.launch

class JMDashboardHomePageVM(
    private val jmMangaRepository: JMMangaRepository,
    private val jmCoverRepository: JMCoverRepository
) : ViewModel(){
    private var popularMangaListWithCovers: MutableList<Pair<JMMangaModel, String>> = mutableListOf()
    private var recentMangaListWithCovers: MutableList<Pair<JMMangaModel, String>> = mutableListOf()
    private var newMangaListWithCovers: MutableList<Pair<JMMangaModel, String>> = mutableListOf()

    val popularMangaListLiveData: MutableLiveData<List<Pair<JMMangaModel, String>>> by lazy {
        MutableLiveData<List<Pair<JMMangaModel, String>>>()
    }
    val recentMangaListLiveData: MutableLiveData<List<Pair<JMMangaModel, String>>> by lazy {
        MutableLiveData<List<Pair<JMMangaModel, String>>>()
    }
    val newMangaListLiveData: MutableLiveData<List<Pair<JMMangaModel, String>>> by lazy {
        MutableLiveData<List<Pair<JMMangaModel, String>>>()
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
                popularMangaListWithCovers.add(Pair(i, jmCoverRepository.getCover(coverId)))
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
                val cover: String = jmCoverRepository.getCover(coverId)
                recentMangaListWithCovers.add(Pair(i, cover))
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
                newMangaListWithCovers.add(Pair(i, jmCoverRepository.getCover(coverId)))
            }
            newMangaListLiveData.value = newMangaListWithCovers
        }
    }


//    fun getRandomManga(): JMMangaModel{
//
//    }
}