package com.areeb.moviesexplorer.data

import androidx.room.TypeConverter
import com.google.gson.Gson

class BelongsToCollectionTypeConverter {
    @TypeConverter
    fun fromString(value: String?): BelongsToCollection? {
        return Gson().fromJson(value, BelongsToCollection::class.java)
    }

    @TypeConverter
    fun toString(value: BelongsToCollection?): String? {
        return Gson().toJson(value)
    }
}
