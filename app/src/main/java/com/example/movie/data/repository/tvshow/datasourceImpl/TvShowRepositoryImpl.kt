package com.example.movie.data.repository.tvshow.datasourceImpl

import android.util.Log
import com.example.movie.data.model.tvShow.TvShow
import com.example.movie.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.movie.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.movie.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.movie.domain.repository.TvRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource

):TvRepository {
    override suspend fun viewTvShow(): List<TvShow>? {
       return getTvShowFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        val newTvShowList = getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.savedTVShowFromDb(newTvShowList)
        tvShowCacheDataSource.saveTvShowFromCache(newTvShowList)

        return newTvShowList
    }



    suspend fun getTvShowFromApi():List<TvShow>
    {
        lateinit var tvShowList:List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if(body!=null)
            {
               tvShowList = body.tvShows
            }
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowFromDb():List<TvShow>
    {
        lateinit var tvShowList:List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDb()
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        if(tvShowList.size>0)
        {
            return tvShowList
        }else{
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.savedTVShowFromDb(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowFromCache():List<TvShow>
    {
        lateinit var tvShowList:List<TvShow>

        try {
            tvShowList= tvShowCacheDataSource.getTvShowFromCache()
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        if(tvShowList.size>0)
        {
            return tvShowList
        }else{
            tvShowList = getTvShowFromDb()
            tvShowCacheDataSource.saveTvShowFromCache(tvShowList)
        }

        return tvShowList
    }


}