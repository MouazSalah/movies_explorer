package com.areeb.moviesexplorer.network.remote

import com.areeb.moviesexplorer.data.MoviesResponse
import com.areeb.moviesexplorer.extesnion.toHashMapParams
import com.areeb.moviesexplorer.network.local.IMoviesILocalDataSourceRepo
import com.areeb.moviesexplorer.network.local.MoviesDao
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesListParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class RemoteDataSourceRepoImpl @Inject constructor(private val apiInterface : MoviesWebServices) :
    IMoviesIRemoteDataSourceRepo {
    override suspend fun getMoviesList(params : MoviesListParams): Flow<List<MoviesResponse>> {
        return apiInterface.getAllMovies(params.toHashMapParams()!!)
    }
}