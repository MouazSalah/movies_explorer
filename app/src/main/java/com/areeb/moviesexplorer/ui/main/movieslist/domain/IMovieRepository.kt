package com.areeb.moviesexplorer.ui.main.movieslist.domain

import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsParams
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesAPIResponse
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    suspend fun getMoviesFromAPI(params : MoviesListParams): MoviesAPIResponse

    suspend fun getMovieDetails(params : MovieDetailsParams): MovieDetailsAPIResponse
}
