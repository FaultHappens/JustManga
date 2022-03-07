package com.example.justmanga.presentation.vm

import android.app.Application
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import androidx.room.Room
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.data.room.db.JMUserPreferencesDB
import com.example.justmanga.domain.model.manga_with_cover.JMMangaWithCoverModel
import com.example.justmanga.domain.repository.cover.JMCoverRepository
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JMDashboardHomePageVM(
    application: Application,
    private val jmMangaRepository: JMMangaRepository,
    private val jmCoverRepository: JMCoverRepository,
) : AndroidViewModel(application){
    private var popularMangaListWithCovers: MutableList<JMMangaWithCoverModel> = mutableListOf()
    private var recentMangaListWithCovers: MutableList<JMMangaWithCoverModel> = mutableListOf()
    private var newMangaListWithCovers: MutableList<JMMangaWithCoverModel> = mutableListOf()

    val db = Room.databaseBuilder(
    getApplication(),
    JMUserPreferencesDB::class.java, "database"
    ).build()

    var dao = db.JMUserPreferencesDAO()

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
            var recentManga: List<String> = listOf()
            withContext(Dispatchers.IO) {
                recentManga = dao.getRecentManga()
            }
            Log.d("RECENT", recentManga.toString())
            val response = jmMangaRepository.searchManga(mapOf("ids[]" to recentManga.toString()))
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