package com.areeb.moviesexplorer.ui.main.moviesdetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.moviesexplorer.BuildConfig
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsParams
import com.areeb.moviesexplorer.ui.main.moviesdetails.domain.MovieDetailsUseCase
import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import com.areeb.moviesexplorer.ui.main.movieslist.ui.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesDetailsViewModel @Inject constructor(private val movieDetailsUseCase: MovieDetailsUseCase) : ViewModel()
{
    var movieDetailParams = MovieDetailsParams(apiKey = BuildConfig.API_KEY)

    private val _moviesDetailsState = MutableStateFlow<MovieDetailsState>(MovieDetailsState.Loading)
    val moviesDetailsState: StateFlow<MovieDetailsState> = _moviesDetailsState

    fun getMovieDetails(movieId : String) {

        "args MovieId = ${movieId}".showLogMessage()

        movieDetailParams.movieId = movieId

        viewModelScope.launch {
            try {
                val movieDetails = movieDetailsUseCase(movieDetailParams)
                "movie Details Success viewModel".showLogMessage()
                _moviesDetailsState.value = MovieDetailsState.Success(movieDetails)
            } catch (e: Exception) {
                _moviesDetailsState.value = MovieDetailsState.Error(e.message ?: "An error occurred")
            }
        }
    }
}