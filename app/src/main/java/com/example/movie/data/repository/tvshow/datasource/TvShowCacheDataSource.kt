package com.example.movie.data.repository.tvshow.datasource

import com.example.movie.data.model.tvShow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowFromCache():List<TvShow>

    suspend fun saveTvShowFromCache(tvShow: List<TvShow>)
}