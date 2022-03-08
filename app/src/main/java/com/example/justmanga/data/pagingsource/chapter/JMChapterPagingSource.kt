package com.example.justmanga.data.pagingsource.chapter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.justmanga.data.apiservice.chapter.JMChapterApiService
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.data.mapper.chapter.response.JMChapterResponseMapper
import com.example.justmanga.domain.model.chapter.response.JMChapterResponse

class JMChapterPagingSource(
    private val chapterApiService: JMChapterApiService,
    private val chapterMapper: JMChapterResponseMapper,
    private val mangaID: String
): PagingSource<Int, JMChapterModel>() {
    override fun getRefreshKey(state: PagingState<Int, JMChapterModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, JMChapterModel> {
        val position = params.key ?: INITIAL_LOAD_SIZE
        val offset = if (params.key != null) ((position - 1) * NETWORK_PAGE_SIZE) + 1 else INITIAL_LOAD_SIZE
        return try {
            val jsonResponse = chapterApiService.getAllMangaChapters(offset = offset.toString(), limit = params.loadSize.toString(), mangaID = mangaID)
            val response = chapterMapper.mapToModel(jsonResponse).data
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object{
        const val NETWORK_PAGE_SIZE = 10
        private const val INITIAL_LOAD_SIZE = 1
    }
}