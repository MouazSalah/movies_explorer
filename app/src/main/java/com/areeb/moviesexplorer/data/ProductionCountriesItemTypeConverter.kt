package com.areeb.moviesexplorer.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.areeb.moviesexplorer.data.ProductionCountriesItem

class ProductionCountriesItemTypeConverter {
	@TypeConverter
	fun fromString(value: String?): List<ProductionCountriesItem?>? {
		val listType = object : TypeToken<List<ProductionCountriesItem>>() {}.type
		return Gson().fromJson(value, listType)
	}

	@TypeConverter
	fun toString(list: List<ProductionCountriesItem?>?): String? {
		return Gson().toJson(list)
	}
}
