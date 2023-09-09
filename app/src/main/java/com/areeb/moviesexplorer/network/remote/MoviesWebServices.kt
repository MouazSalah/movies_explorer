package com.areeb.moviesexplorer.network.remote

import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesAPIResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*

interface MoviesWebServices {

    companion object {
        private const val GET_ALL_MOVIES = "discover/movie"
        private const val GET_MOVIE_DETAILS = "movie/{movieId}"
  }

    @GET(GET_ALL_MOVIES)
    suspend fun getAllMovies(@QueryMap param: HashMap<String, String?>): MoviesAPIResponse


    @GET(GET_MOVIE_DETAILS)
    suspend fun getMovieDetails(@Path("movieId") movieId : String , @Query("api_key") apiKey : String): MovieDetailsAPIResponse

}