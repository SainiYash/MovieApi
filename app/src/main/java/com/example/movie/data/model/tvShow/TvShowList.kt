package com.example.movie.data.model.tvShow


import com.example.movie.data.model.tvShow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>

)