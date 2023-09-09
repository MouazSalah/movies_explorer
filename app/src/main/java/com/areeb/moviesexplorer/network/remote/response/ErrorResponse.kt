package com.areeb.moviesexplorer.network.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorResponse(
    var message: String? = null
) : Parcelable
