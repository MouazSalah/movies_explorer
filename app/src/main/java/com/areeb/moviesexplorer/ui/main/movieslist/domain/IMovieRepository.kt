package com.areeb.moviesexplorer.ui.main.movieslist.domain

import com.areeb.moviesexplorer.data.MoviesResponse
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams

interface IMovieRepository {
    suspend fun getMoviesFromAPI(params : MoviesListParams): List<MoviesResponse>
}
