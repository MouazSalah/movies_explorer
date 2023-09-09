package com.areeb.moviesexplorer.ui.main.moviesdetails.data

import com.areeb.moviesexplorer.core.HashMapParams
import com.google.gson.annotations.SerializedName

data class MovieDetailsParams(
    @SerializedName("api_key")
    var apiKey: String? = null,

    @SerializedName("movieId")
    var movieId: String? = null
) : HashMapParams {
    override fun dataClass(): Any = this
}