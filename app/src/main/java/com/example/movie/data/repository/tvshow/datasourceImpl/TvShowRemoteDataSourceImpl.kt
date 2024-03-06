package com.example.movie.data.repository.tvshow.datasourceImpl

import com.example.movie.data.api.TMDBService
import com.example.movie.data.model.tvShow.TvShowList
import com.example.movie.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String): TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> {
        return tmdbService.getPopularTV(apiKey)
    }

}