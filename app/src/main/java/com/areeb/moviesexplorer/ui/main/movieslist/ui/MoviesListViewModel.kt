package com.areeb.moviesexplorer.ui.main.movieslist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.moviesexplorer.BuildConfig
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.network.local.LocalUseCase
import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import com.areeb.moviesexplorer.ui.main.movieslist.domain.MoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(private val moviesListUseCase: MoviesListUseCase) : ViewModel() {

    var moviesListParams = MoviesListParams(apiKey = BuildConfig.API_KEY, page = 1)
    var totalPages: Int = 1

    private val _moviesListState = MutableStateFlow<MoviesListState>(MoviesListState.Loading)
    val moviesListState: StateFlow<MoviesListState> = _moviesListState

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                val movies = moviesListUseCase(moviesListParams)
                totalPages = movies.totalPages ?: 1
                _moviesListState.value = MoviesListState.Success(movies.results as ArrayList<MovieResponseItem>)
            } catch (e: Exception) {
                _moviesListState.value = MoviesListState.Error(e.message ?: "An error occurred")
            }
        }
    }
}
