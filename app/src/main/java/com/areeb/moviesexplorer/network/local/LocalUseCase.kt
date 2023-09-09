package com.areeb.moviesexplorer.network.local

import com.areeb.moviesexplorer.data.MoviesResponse
import javax.inject.Inject
class LocalUseCase @Inject constructor(private val iMoviesILocalDataSourceRepo: IMoviesILocalDataSourceRepo) {

    suspend fun loadMovies(): List<MoviesResponse> = iMoviesILocalDataSourceRepo.loadMovies()

    suspend fun insertMovies(years: List<MoviesResponse>) = iMoviesILocalDataSourceRepo.insertMovies(years)
}