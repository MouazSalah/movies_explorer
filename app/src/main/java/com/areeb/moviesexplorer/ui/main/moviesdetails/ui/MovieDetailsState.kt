package com.areeb.moviesexplorer.ui.main.moviesdetails.ui

import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse

sealed class MovieDetailsState {
    object Loading : MovieDetailsState()
    data class Success(val movieDetails : MovieDetailsAPIResponse?) : MovieDetailsState()
    data class Error(val errorMessage: String) : MovieDetailsState()
}
