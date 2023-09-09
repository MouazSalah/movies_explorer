package com.areeb.moviesexplorer.network.remote

import com.areeb.moviesexplorer.data.MoviesResponse
import com.areeb.moviesexplorer.network.remote.response.ErrorResponse
import com.areeb.moviesexplorer.network.remote.response.NetworkResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*
interface MoviesWebServices {

    companion object {
        private const val GET_ALL_MOVIES = "discover/movie"
        private const val GET_MOVIE_DETAILS = "movie/"
  }

    @GET(GET_ALL_MOVIES)
    suspend fun getAllMovies(@QueryMap param: HashMap<String, String?>): Flow<List<MoviesResponse>>


    @GET(GET_MOVIE_DETAILS)
    suspend fun getMovieDetails(@QueryMap param: HashMap<String, String?>): NetworkResponse<List<MoviesResponse>, ErrorResponse>

}