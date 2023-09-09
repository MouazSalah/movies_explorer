package com.areeb.moviesexplorer.network.remote

import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsParams
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesAPIResponse
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import kotlinx.coroutines.flow.Flow

interface IMoviesIRemoteDataSourceRepo {
    suspend fun getMoviesList(params : MoviesListParams) : MoviesAPIResponse

    suspend fun getMovieDetails(params : MovieDetailsParams) : MovieDetailsAPIResponse
}