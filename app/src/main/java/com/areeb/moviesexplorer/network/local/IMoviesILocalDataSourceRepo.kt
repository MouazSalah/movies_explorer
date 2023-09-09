package com.areeb.moviesexplorer.network.local

import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem

interface IMoviesILocalDataSourceRepo {
    suspend fun loadMovies(): List<MovieResponseItem>

    suspend fun insertMovies(years: List<MovieResponseItem>)

}