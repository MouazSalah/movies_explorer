package com.areeb.moviesexplorer.network.remote

import com.areeb.moviesexplorer.data.MoviesResponse
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import kotlinx.coroutines.flow.Flow

interface IMoviesIRemoteDataSourceRepo {
    suspend fun getMoviesList(params : MoviesListParams) : Flow<List<MoviesResponse>>
}