package com.areeb.moviesexplorer.ui.main.movieslist.ui

import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem

sealed class MoviesListState {
    object Loading : MoviesListState()
    data class Success(val movies: List<MovieResponseItem>) : MoviesListState()
    data class Error(val errorMessage: String) : MoviesListState()
}
