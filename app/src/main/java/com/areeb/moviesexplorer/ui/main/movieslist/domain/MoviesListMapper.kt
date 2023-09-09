package com.areeb.moviesexplorer.ui.main.movieslist.domain

import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieItem
import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import com.areeb.moviesexplorer.ui.main.movieslist.data.MoviesAPIResponse

class MoviesListMapper {
    fun mapToMovieItem(response: MovieResponseItem): MovieItem {
        return MovieItem(
            id = response.id,
            originalLanguage = response.originalLanguage,
            video = response.video,
            title = response.title,
            backdropPath = response.backdropPath,
            popularity = response.popularity,
            voteCount = response.voteCount,
            overview = response.overview,
            originalTitle = response.originalTitle,
            posterPath = response.posterPath,
            releaseDate = response.releaseDate,
            adult = response.adult
        )
    }

}

