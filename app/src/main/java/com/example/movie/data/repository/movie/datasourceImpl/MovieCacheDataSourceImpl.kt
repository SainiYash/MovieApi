package com.example.movie.data.repository.movie.datasourceImpl

import com.example.movie.data.model.movie.Movie
import com.example.movie.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()
    override suspend fun getMovieFromCache(): List<Movie> {
           return movieList
    }

    override suspend fun saveMovieFromCache(movie: List<Movie>) {
       movieList.clear()
        movieList = ArrayList(movie)
    }




}