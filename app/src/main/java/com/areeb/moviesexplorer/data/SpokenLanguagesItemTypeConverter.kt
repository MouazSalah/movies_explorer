package com.areeb.moviesexplorer.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.areeb.moviesexplorer.data.SpokenLanguagesItem

class SpokenLanguagesItemTypeConverter {
	@TypeConverter
	fun fromString(value: String?): List<SpokenLanguagesItem?>? {
		val listType = object : TypeToken<List<SpokenLanguagesItem>>() {}.type
		return Gson().fromJson(value, listType)
	}

	@TypeConverter
	fun toString(list: List<SpokenLanguagesItem?>?): String? {
		return Gson().toJson(list)
	}
}
