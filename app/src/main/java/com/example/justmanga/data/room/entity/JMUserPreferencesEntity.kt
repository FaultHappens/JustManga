package com.example.justmanga.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class userPreferences(
    @ColumnInfo(name = "theme_color")
    val theme_color: Int,

    @ColumnInfo(name = "liked_manga")
    val liked_manga: List<String>,

    @ColumnInfo(name = "recent_manga")
    val recent_manga: List<String>


)