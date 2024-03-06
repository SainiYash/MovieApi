package com.example.movie.data.repository.tvshow.datasource

import com.example.movie.data.model.tvShow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowFromDb():List<TvShow>
    suspend fun savedTVShowFromDb(tvShow: List<TvShow>)

    suspend fun clearAll()


}