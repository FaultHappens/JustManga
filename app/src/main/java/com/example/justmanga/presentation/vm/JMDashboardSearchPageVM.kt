package com.example.justmanga.presentation.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import com.example.justmanga.domain.repository.tag.JMTagRepository
import kotlinx.coroutines.launch

class JMDashboardSearchPageVM(
    private val jmTagRepository: JMTagRepository
) : ViewModel() {
    fun updateTagList() {
        viewModelScope.launch {
            val response = jmTagRepository.getAllTag()
            Log.d("awdawdawd", response.body().toString())
        }
    }
}