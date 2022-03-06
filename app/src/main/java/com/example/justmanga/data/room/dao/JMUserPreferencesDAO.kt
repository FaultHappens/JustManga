package com.example.justmanga.data.room.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface JMUserPreferencesDAO {
    @Query("SELECT theme_color FROM userPreferences")
    fun getThemeColor(): Int

    @Query("SELECT recent_manga FROM userPreferences")
    fun getRecentManga(): List<String>

    @Query("SELECT liked_manga FROM userPreferences")
    fun getLikedManga(): List<String>

    @Query("SELECT theme_color FROM userPreferences")
    fun addRecentManga()

    @Query("SELECT theme_color FROM userPreferences")
    fun addLikedManga()

    @Query("SELECT theme_color FROM userPreferences")
    fun deleteLikedManga()
}