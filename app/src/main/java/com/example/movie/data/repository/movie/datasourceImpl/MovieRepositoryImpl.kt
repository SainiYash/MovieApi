package com.example.movie.data.repository.movie.datasourceImpl

import android.util.Log
import com.example.movie.data.model.movie.Movie
import com.example.movie.data.repository.movie.datasource.MovieCacheDataSource
import com.example.movie.data.repository.movie.datasource.MovieLocalDataSource
import com.example.movie.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.movie.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
):MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
       return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovie = getMoviefromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.savedMovieFromDb(newListOfMovie)
        movieCacheDataSource.saveMovieFromCache(newListOfMovie)

        return newListOfMovie
    }

    suspend fun getMoviefromApi():List<Movie>
    {
        lateinit var movieList:List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null)
            {
                movieList = body.movies
            }
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDb():List<Movie>
    {
        lateinit var movieList:List<Movie>

        try {
         movieList = movieLocalDataSource.getMoviesFromDb()
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        if(movieList.size>0)
        {
             return movieList
        }else{
               movieList = getMoviefromApi()
            movieLocalDataSource.savedMovieFromDb(movieList)
        }

        return movieList
    }

    suspend fun getMovieFromCache():List<Movie>
    {
        lateinit var movieList:List<Movie>

        try {
            movieList = movieCacheDataSource.getMovieFromCache()
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        if(movieList.size>0)
        {
            return movieList
        }else{
            movieList = getMoviesFromDb()
            movieCacheDataSource.saveMovieFromCache(movieList)
        }

        return movieList
    }

}