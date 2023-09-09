package com.areeb.moviesexplorer.ui.main.movieslist.ui

import com.areeb.moviesexplorer.data.MovieItem

sealed class MoviesListState {
    object Loading : MoviesListState()
    data class Success(val movies: List<MovieItem>) : MoviesListState()
    data class Error(val errorMessage: String) : MoviesListState()
}
