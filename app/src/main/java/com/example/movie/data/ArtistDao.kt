package com.example.movie.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie.data.model.artist.Artist
import com.example.movie.data.model.movie.Movie

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist: List<Artist>)

    @Query("DELETE FROM POPULAR_ARTIST")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM POPULAR_ARTIST")
    suspend fun getArtist():List<Artist>





}