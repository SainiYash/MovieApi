package com.example.movie.data.repository.movie.datasource

import com.example.movie.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}