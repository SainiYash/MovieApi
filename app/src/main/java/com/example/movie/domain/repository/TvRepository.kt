package com.example.movie.domain.repository

import com.example.movie.data.model.tvShow.TvShow

interface TvRepository {

    suspend fun viewTvShow():List<TvShow>?
    suspend fun updateTvShow():List<TvShow>?
}