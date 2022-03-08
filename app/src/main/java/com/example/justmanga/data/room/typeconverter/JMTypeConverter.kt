package com.example.justmanga.data.room.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class JMTypeConverter {
    @TypeConverter
    fun fromListToString(stringList: List<String>): String {
        return Gson().toJson(stringList)
    }

    @TypeConverter
    fun fromStringToList(string: String): List<String>{
        val listType: Type = object : TypeToken<ArrayList<String?>?>(){}.type
        return Gson().fromJson(string, listType)
    }
}