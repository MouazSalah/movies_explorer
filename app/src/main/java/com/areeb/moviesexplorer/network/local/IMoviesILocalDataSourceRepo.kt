package com.areeb.moviesexplorer.network.local

import com.areeb.moviesexplorer.data.MoviesResponse

interface IMoviesILocalDataSourceRepo {
    suspend fun loadMovies(): List<MoviesResponse>

    suspend fun insertMovies(years: List<MoviesResponse>)

}