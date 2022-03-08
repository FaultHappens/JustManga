package com.example.justmanga.data.room.dao

import androidx.room.*
import com.example.justmanga.data.room.entity.LikedManga
import com.example.justmanga.data.room.entity.RecentManga

@Dao
interface JMUserPreferencesDAO {
    @Query("SELECT theme_color FROM userPreferences")
    fun getThemeColor(): Int

    @Query("SELECT manga_id FROM RecentManga")
    fun getRecentManga(): List<String>

    @Query("SELECT manga_id FROM LikedManga")
    fun getLikedManga(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRecentManga(manga_id: RecentManga)

    @Insert
    fun addLikedManga(manga_id: LikedManga)

    @Delete
    fun deleteLikedManga(manga_id: LikedManga)
}