package com.areeb.moviesexplorer.di

import android.content.Context
import androidx.room.Room
import com.areeb.moviesexplorer.network.local.IMoviesILocalDataSourceRepo
import com.areeb.moviesexplorer.network.local.LocalDataSourceRepoImpl
import com.areeb.moviesexplorer.network.local.MoviesDao
import com.areeb.moviesexplorer.network.local.RoomAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataBaseModule {

    companion object {
        private const val DATA_BASE_NAME = "IMDB_Movies_database"
    }

    @Singleton
    @Provides
    fun provideIntroDao(dataBase: RoomAppDatabase): MoviesDao = dataBase.moviesDao()


    @Singleton
    @Provides
    fun provideLocalDataSource(moviesDao : MoviesDao): IMoviesILocalDataSourceRepo = LocalDataSourceRepoImpl(moviesDao)


    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): RoomAppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            RoomAppDatabase::class.java,
            DATA_BASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }
}