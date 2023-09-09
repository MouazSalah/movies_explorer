package com.areeb.moviesexplorer.ui.main.movieslist.domain

import com.areeb.moviesexplorer.data.MovieItem
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import javax.inject.Inject

class MoviesListUseCase @Inject constructor(private val repository: IMovieRepository) {
    suspend operator fun invoke(params: MoviesListParams): List<MovieItem> {
        val moviesAPIList = repository.getMoviesFromAPI(params)

        "movies UseCase success = ${moviesAPIList.size.toString()}".showLogMessage()

        return moviesAPIList.map { MoviesListMapper().mapToMovieItem(it) }
    }
}
