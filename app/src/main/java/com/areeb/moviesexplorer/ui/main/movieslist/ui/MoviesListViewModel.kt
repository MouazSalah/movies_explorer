package com.areeb.moviesexplorer.ui.main.movieslist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.moviesexplorer.BuildConfig
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import com.areeb.moviesexplorer.ui.main.movieslist.domain.MoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor( private val moviesListUseCase: MoviesListUseCase) : ViewModel()
{
    private var moviesListParams = MoviesListParams(apiKey = BuildConfig.API_KEY)

    private val _moviesListState = MutableStateFlow<MoviesListState>(MoviesListState.Loading)
    val moviesListState: StateFlow<MoviesListState> = _moviesListState

    init {
        fetchMovies(moviesListParams) // You can initialize the data loading in the constructor if needed.
    }

    private fun fetchMovies(params: MoviesListParams) {
        viewModelScope.launch {
            try {
                val movies = moviesListUseCase(params)
                "movies viewModel success = ${movies.toString()}".showLogMessage()

                _moviesListState.value = MoviesListState.Success(movies)
            } catch (e: Exception) {
                "movies viewModel exception = ${e.message}".showLogMessage()
                _moviesListState.value = MoviesListState.Error(e.message ?: "An error occurred")
            }
        }
    }

}