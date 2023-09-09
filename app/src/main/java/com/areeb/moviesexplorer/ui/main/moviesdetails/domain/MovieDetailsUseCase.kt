package com.areeb.moviesexplorer.ui.main.moviesdetails.domain

import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsParams
import com.areeb.moviesexplorer.ui.main.movieslist.domain.IMovieRepository
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(private val repository: IMovieRepository) {
    suspend operator fun invoke(params: MovieDetailsParams): MovieDetailsAPIResponse {

        "MovieDetailsUseCase calling".showLogMessage()

        return repository.getMovieDetails(params)
    }

}
