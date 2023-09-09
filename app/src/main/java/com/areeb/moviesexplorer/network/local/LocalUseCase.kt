package com.areeb.moviesexplorer.network.local

import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import javax.inject.Inject
class LocalUseCase @Inject constructor(private val iMoviesILocalDataSourceRepo: IMoviesILocalDataSourceRepo) {

    suspend fun loadMovies(): List<MovieResponseItem> = iMoviesILocalDataSourceRepo.loadMovies()

    suspend fun insertMovies(movies: List<MovieResponseItem>) = iMoviesILocalDataSourceRepo.insertMovies(movies)
}