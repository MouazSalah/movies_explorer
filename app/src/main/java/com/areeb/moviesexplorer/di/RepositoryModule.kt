package com.areeb.moviesexplorer.di

import com.areeb.moviesexplorer.network.local.IMoviesILocalDataSourceRepo
import com.areeb.moviesexplorer.network.local.LocalDataSourceRepoImpl
import com.areeb.moviesexplorer.network.local.MoviesDao
import com.areeb.moviesexplorer.network.remote.IMoviesIRemoteDataSourceRepo
import com.areeb.moviesexplorer.network.remote.MoviesWebServices
import com.areeb.moviesexplorer.network.remote.RemoteDataSourceRepoImpl
import com.areeb.moviesexplorer.ui.main.movieslist.domain.IMovieRepository
import com.areeb.moviesexplorer.ui.main.movieslist.domain.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideLocalDataSourceRepo(moviesDao: MoviesDao): IMoviesILocalDataSourceRepo = LocalDataSourceRepoImpl(moviesDao)


    @Singleton
    @Provides
    fun provideRemoteDataSourceRepo(apiInterface: MoviesWebServices): IMoviesIRemoteDataSourceRepo = RemoteDataSourceRepoImpl(apiInterface)


    @Singleton
    @Provides
    fun provideMoviesRepository(remoteDataSource: RemoteDataSourceRepoImpl,
                                localDataSource: LocalDataSourceRepoImpl): IMovieRepository = MovieRepositoryImpl(remoteDataSource, localDataSource)

}