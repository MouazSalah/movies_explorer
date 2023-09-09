package com.areeb.moviesexplorer.network.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.areeb.moviesexplorer.ui.main.movieslist.data.GenresIDTypeConverter
import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem

@Database(entities = [MovieResponseItem::class], version = 2, exportSchema = false)
@TypeConverters(GenresIDTypeConverter::class)
abstract class RoomAppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}