package com.areeb.moviesexplorer.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.areeb.moviesexplorer.data.ProductionCompaniesItem

class ProductionCompaniesItemTypeConverter {
	@TypeConverter
	fun fromString(value: String?): List<ProductionCompaniesItem?>? {
		val listType = object : TypeToken<List<ProductionCompaniesItem>>() {}.type
		return Gson().fromJson(value, listType)
	}

	@TypeConverter
	fun toString(list: List<ProductionCompaniesItem?>?): String? {
		return Gson().toJson(list)
	}
}
