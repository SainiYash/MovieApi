package com.example.movie.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //So, room will replace the old data and continue the transaction.
    suspend fun saveMovies(movies:List<Movie>)

    @Query("DELETE FROM POPULAR_MOVIE")
    suspend fun deleteAllMovies()

     @Query("SELECT * FROM POPULAR_MOVIE")
    suspend fun getMovie():List<Movie>



}