package com.areeb.moviesexplorer.network.local

import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import javax.inject.Inject
class LocalDataSourceRepoImpl @Inject constructor(private val moviesDao: MoviesDao) :
    IMoviesILocalDataSourceRepo {

    override suspend fun loadMovies(): List<MovieResponseItem> = moviesDao.loadMovies()

    override suspend fun insertMovies(moviesList : List<MovieResponseItem>) = moviesDao.insertMovies(moviesList)

}