package com.example.movie.data.repository.movie.datasource

import com.example.movie.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMovieFromCache():List<Movie>
    suspend fun saveMovieFromCache(movie:List<Movie>)
}