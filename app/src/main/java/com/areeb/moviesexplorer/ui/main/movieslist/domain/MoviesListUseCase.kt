package com.areeb.moviesexplorer.ui.main.movieslist.domain

import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesAPIResponse
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import javax.inject.Inject

class MoviesListUseCase @Inject constructor(private val repository: IMovieRepository) {
    suspend operator fun invoke(params: MoviesListParams): MoviesAPIResponse {
        return repository.getMoviesFromAPI(params)
    }

    suspend fun getCashedMovies(): List<MovieResponseItem> {
        return repository.getMoviesFromRoom()
    }
}
