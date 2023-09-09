package com.areeb.moviesexplorer.ui.main.movieslist.domain

import com.areeb.moviesexplorer.data.MoviesResponse
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.network.local.LocalDataSourceRepoImpl
import com.areeb.moviesexplorer.network.remote.RemoteDataSourceRepoImpl
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSourceRepoImpl,
    private val localDataSource: LocalDataSourceRepoImpl
) : IMovieRepository {

    override suspend fun getMoviesFromAPI(params : MoviesListParams): List<MoviesResponse> {

        val moviesList = mutableListOf<MoviesResponse>()

        remoteDataSource.getMoviesList(params).collect { movies ->
            "movies Repo Collect  = ${movies.size.toString()}".showLogMessage()
            moviesList.addAll(movies)
        }

        localDataSource.insertMovies(moviesList)

        return moviesList
    }

}
