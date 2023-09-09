package com.areeb.moviesexplorer.network.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.areeb.moviesexplorer.data.BelongsToCollectionTypeConverter
import com.areeb.moviesexplorer.data.GenresItemTypeConverter
import com.areeb.moviesexplorer.data.MoviesResponse
import com.areeb.moviesexplorer.data.ProductionCompaniesItemTypeConverter
import com.areeb.moviesexplorer.data.ProductionCountriesItemTypeConverter
import com.areeb.moviesexplorer.data.SpokenLanguagesItemTypeConverter
import com.areeb.moviesexplorer.network.local.MoviesDao

@Database(entities = [MoviesResponse::class], version = 1, exportSchema = false)
@TypeConverters(
    GenresItemTypeConverter::class,
    ProductionCountriesItemTypeConverter::class,
    SpokenLanguagesItemTypeConverter::class,
    ProductionCompaniesItemTypeConverter::class,
    BelongsToCollectionTypeConverter::class
)
abstract class RoomAppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}