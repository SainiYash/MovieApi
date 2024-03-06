package com.example.movie.domain.repository

import com.example.movie.data.model.movie.Movie
import com.example.movie.data.model.tvShow.TvShow

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?



}