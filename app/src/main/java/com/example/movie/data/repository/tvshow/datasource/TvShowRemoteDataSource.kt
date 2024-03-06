package com.example.movie.data.repository.tvshow.datasource

import com.example.movie.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShow():Response<TvShowList>
}