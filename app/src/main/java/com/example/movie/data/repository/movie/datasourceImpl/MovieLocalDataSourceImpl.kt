package com.example.movie.data.repository.movie.datasourceImpl

import com.example.movie.data.db.MovieDao
import com.example.movie.data.model.movie.Movie
import com.example.movie.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie> {
     return movieDao.getMovie()
    }

    override suspend fun savedMovieFromDb(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movie)
        }
    }

    override suspend fun clearAll() {
      CoroutineScope(Dispatchers.IO).launch {
          movieDao.deleteAllMovies()
      }
    }
}