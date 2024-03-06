package com.example.movie.data.repository.movie.datasource

import com.example.movie.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDb():List<Movie>
    suspend fun savedMovieFromDb(movie: List<Movie>)
    suspend fun clearAll()
}