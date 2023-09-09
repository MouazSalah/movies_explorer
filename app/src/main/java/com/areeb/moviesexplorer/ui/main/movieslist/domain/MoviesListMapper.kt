package com.areeb.moviesexplorer.ui.main.movieslist.domain

import com.areeb.moviesexplorer.data.MovieItem
import com.areeb.moviesexplorer.data.MoviesResponse

class MoviesListMapper {
    fun mapToMovieItem(response: MoviesResponse): MovieItem {
        return MovieItem(
            id = response.id,
            originalLanguage = response.originalLanguage,
            imdbId = response.imdbId,
            video = response.video,
            title = response.title,
            backdropPath = response.backdropPath,
            revenue = response.revenue,
            popularity = response.popularity,
            voteCount = response.voteCount,
            budget = response.budget,
            overview = response.overview,
            originalTitle = response.originalTitle,
            runtime = response.runtime,
            posterPath = response.posterPath,
            releaseDate = response.releaseDate,
            voteAverage = response.voteAverage,
            tagline = response.tagline,
            adult = response.adult,
            homepage = response.homepage,
            status = response.status,
            movieGenre = response.genres?.joinToString { it?.name.orEmpty() }, // Join genre names into a single string
            movieCollection = response.belongsToCollection?.name.orEmpty(),
            productionCompanyLogo = response.productionCompanies?.getOrNull(0)?.logoPath.orEmpty(),
            productionCompanyName = response.productionCompanies?.getOrNull(0)?.name.orEmpty(),
            productionCountryName = response.productionCountries?.joinToString { it?.name.orEmpty() }, // Join country names into a single string
            spokenLanguage = response.spokenLanguages?.joinToString { it?.name.orEmpty() } // Join spoken language names into a single string
        )
    }

}

