package com.example.movie.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie.data.model.tvShow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShow: List<TvShow>)

    @Query("DELETE FROM POPULAR_TV")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM  POPULAR_TV")
    suspend fun getAllTvShow():List<TvShow>

}