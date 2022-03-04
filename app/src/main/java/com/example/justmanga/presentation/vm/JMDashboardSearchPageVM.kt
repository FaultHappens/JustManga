package com.example.justmanga.presentation.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justmanga.data.dto.tag.response.JMTagModel
import com.example.justmanga.domain.repository.tag.JMTagRepository
import kotlinx.coroutines.launch

class JMDashboardSearchPageVM(
    private val jmTagRepository: JMTagRepository
) : ViewModel() {

    val tagLiveData: MutableLiveData<List<JMTagModel>> by lazy {
        MutableLiveData<List<JMTagModel>>()
    }

    fun updateTagList() {
        viewModelScope.launch {
            val response = jmTagRepository.getAllTag()
            tagLiveData.value = response.data
        }
    }
}