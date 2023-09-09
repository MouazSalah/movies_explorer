package com.areeb.moviesexplorer.ui.main.movieslist.domain

import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.network.local.LocalDataSourceRepoImpl
import com.areeb.moviesexplorer.network.remote.RemoteDataSourceRepoImpl
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsParams
import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesAPIResponse
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSourceRepoImpl,
    private val localDataSource: LocalDataSourceRepoImpl
) : IMovieRepository {

    override suspend fun getMoviesFromAPI(params : MoviesListParams): MoviesAPIResponse {

        val moviesList : List<MovieResponseItem> = remoteDataSource.getMoviesList(params).results as List<MovieResponseItem>

        localDataSource.insertMovies(moviesList)

        return remoteDataSource.getMoviesList(params)
    }
    override suspend fun getMoviesFromRoom(): List<MovieResponseItem> {
        return localDataSource.loadMovies()
    }


    override suspend fun getMovieDetails(params: MovieDetailsParams): MovieDetailsAPIResponse {
        return remoteDataSource.getMovieDetails(params)
    }

}
