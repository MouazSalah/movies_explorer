package com.areeb.moviesexplorer.network.remote

import com.areeb.moviesexplorer.BuildConfig
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.extesnion.toHashMapParams
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsParams
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesAPIResponse
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceRepoImpl @Inject constructor(private val apiInterface : MoviesWebServices) :
    IMoviesIRemoteDataSourceRepo {
    override suspend fun getMoviesList(params : MoviesListParams): MoviesAPIResponse {
        return apiInterface.getAllMovies(param = params.toHashMapParams()!!)
    }

    override suspend fun getMovieDetails(params: MovieDetailsParams): MovieDetailsAPIResponse {
        "Repository calling".showLogMessage()
        return apiInterface.getMovieDetails(movieId = params.movieId ?: "1", apiKey = params.apiKey ?: BuildConfig.API_KEY)
    }
}