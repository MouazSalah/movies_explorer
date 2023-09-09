package com.areeb.moviesexplorer.network.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.areeb.moviesexplorer.data.MoviesResponse

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies")
    suspend fun loadMovies(): List<MoviesResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(years: List<MoviesResponse>)
}
