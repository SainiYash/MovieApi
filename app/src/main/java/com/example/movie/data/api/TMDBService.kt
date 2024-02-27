package com.example.movie.data.api

import com.example.movie.data.model.artist.ArtistList
import com.example.movie.data.model.movie.MovieList
import com.example.movie.data.model.tvShow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {


    @GET("movie/popular")
    suspend fun getPopularMovies(@Query(value = "api_key")apikey:String):Response<MovieList>

    @GET("trending/tv")
    suspend fun getPopularTV(@Query(value = "api_key")apikey:String):Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query(value = "api_key")apikey:String):Response<ArtistList>


}