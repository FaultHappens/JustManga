package com.example.justmanga.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.justmanga.data.room.dao.JMUserPreferencesDAO
import com.example.justmanga.data.room.entity.LikedManga
import com.example.justmanga.data.room.entity.RecentManga
import com.example.justmanga.data.room.entity.UserPreferences

@Database(entities = [UserPreferences::class, LikedManga::class, RecentManga::class], version = 1)
abstract class JMUserPreferencesDB: RoomDatabase() {
    abstract fun JMUserPreferencesDAO(): JMUserPreferencesDAO
}