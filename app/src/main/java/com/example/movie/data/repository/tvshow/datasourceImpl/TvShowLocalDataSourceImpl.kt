package com.example.movie.data.repository.tvshow.datasourceImpl

import com.example.movie.data.db.TvShowDao
import com.example.movie.data.model.tvShow.TvShow
import com.example.movie.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao:TvShowDao): TvShowLocalDataSource
{
    override suspend fun getTvShowFromDb(): List<TvShow> {
      return tvShowDao.getAllTvShow()
    }

    override suspend fun savedTVShowFromDb(tvShow: List<TvShow>) {
       CoroutineScope(Dispatchers.IO).launch {
           tvShowDao.saveTvShow(tvShow)
       }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           tvShowDao.deleteAllTvShow()
       }
    }
}