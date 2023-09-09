package com.areeb.moviesexplorer.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class GenresItemTypeConverter {
    @TypeConverter
    fun fromString(value: String?): List<GenresItem>? {
        val listType = object : TypeToken<List<GenresItem>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(list: List<GenresItem>?): String? {
        return Gson().toJson(list)
    }
}
