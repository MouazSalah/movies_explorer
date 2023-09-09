package com.areeb.moviesexplorer.network.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_table")
    suspend fun loadMovies(): List<MovieResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(years: List<MovieResponseItem>)
}
