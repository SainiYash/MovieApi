package com.example.movie.data.repository.movie.datasourceImpl

import com.example.movie.data.api.TMDBService
import com.example.movie.data.model.movie.MovieList
import com.example.movie.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apikey:String):
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
      return tmdbService.getPopularMovies(apikey)
    }
}