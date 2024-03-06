package com.example.movie.data.repository.tvshow.datasourceImpl

import com.example.movie.data.model.tvShow.TvShow
import com.example.movie.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList

    }

    override suspend fun saveTvShowFromCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}