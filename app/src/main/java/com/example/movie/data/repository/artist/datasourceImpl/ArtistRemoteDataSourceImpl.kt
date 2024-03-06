package com.example.movie.data.repository.artist.datasourceImpl

import com.example.movie.data.api.TMDBService
import com.example.movie.data.model.artist.ArtistList
import com.example.movie.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey:String)
    : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }
}