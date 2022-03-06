package com.example.justmanga.data.room.db

import androidx.room.Database
import com.example.justmanga.data.room.dao.JMUserPreferencesDAO
import com.example.justmanga.data.room.entity.userPreferences


@Database(entities = [userPreferences::class], version = 1)
abstract class JMUserPreferencesDB {
    abstract fun JMUserPreferencesDAO(): JMUserPreferencesDAO
}