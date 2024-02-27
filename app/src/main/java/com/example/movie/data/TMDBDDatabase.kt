package com.example.movie.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movie.data.model.artist.Artist
import com.example.movie.data.model.movie.Movie
import com.example.movie.data.model.tvShow.TvShow

@Database(entities = [Movie::class, TvShow::class,Artist::class],
version = 1,
    exportSchema = false
)
abstract class TMDBDDatabase : RoomDatabase() {
}