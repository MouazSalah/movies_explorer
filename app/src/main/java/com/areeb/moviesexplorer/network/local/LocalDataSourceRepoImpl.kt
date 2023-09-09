package com.areeb.moviesexplorer.network.local

import com.areeb.moviesexplorer.data.MoviesResponse
import javax.inject.Inject
class LocalDataSourceRepoImpl @Inject constructor(private val moviesDao: MoviesDao) :
    IMoviesILocalDataSourceRepo {

    override suspend fun loadMovies(): List<MoviesResponse> = moviesDao.loadMovies()

    override suspend fun insertMovies(moviesList : List<MoviesResponse>) = moviesDao.insertMovies(moviesList)

}