package com.areeb.moviesexplorer.ui.main.movieslist.data

import com.areeb.moviesexplorer.core.HashMapParams
import com.google.gson.annotations.SerializedName

data class MoviesListParams(
    @SerializedName("api_key")
    var apiKey: String? = null,

    @SerializedName("page")
    var page: Int? = null
) : HashMapParams {
    override fun dataClass(): Any = this
}