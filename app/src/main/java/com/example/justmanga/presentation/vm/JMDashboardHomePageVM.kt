package com.example.justmanga.presentation.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.data.room.db.JMUserPreferencesDB
import com.example.justmanga.domain.model.manga.response.JMMangaResponse
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

    //TODO: add func that will only load last added recent manga
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

    //TODO: add func that will only load last added recent manga
    fun updateRecentMangaList(){

        viewModelScope.launch {
            recentMangaListWithCovers.clear()
            var recentManga: List<String>
            withContext(Dispatchers.IO) {
                recentManga = dao.getRecentManga()
            }

            lateinit var response: JMMangaResponse

            //Sorting the response data i got, because API sends mangas not in order that i requested, but in some random order
            if(recentManga.isNotEmpty()){
                val sortedManga: MutableList<JMMangaModel> = mutableListOf()
                val notSortedResponse = jmMangaRepository.searchMangaWithID(recentManga)
                for(j in recentManga){
                    for(i in notSortedResponse.data){
                        if(j == i.id){
                            sortedManga.add(i)
                        }
                    }
                }
                response = JMMangaResponse(sortedManga, notSortedResponse.limit, notSortedResponse.offset, notSortedResponse.response, notSortedResponse.result, notSortedResponse.total)
            }else{
                response = jmMangaRepository.getAllManga()
            }
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