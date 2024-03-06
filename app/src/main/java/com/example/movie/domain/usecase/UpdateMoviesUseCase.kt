package com.example.movie.domain.usecase

import com.example.movie.data.model.movie.Movie
import com.example.movie.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

  suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}