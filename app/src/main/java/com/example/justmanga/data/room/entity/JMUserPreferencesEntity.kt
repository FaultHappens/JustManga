package com.example.justmanga.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserPreferences(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "theme_color")
    val theme_color: Int
)

@Entity
data class RecentManga(
    @PrimaryKey
    val manga_id: String,
)

@Entity
data class LikedManga(
    @PrimaryKey
    val manga_id: String,
)

