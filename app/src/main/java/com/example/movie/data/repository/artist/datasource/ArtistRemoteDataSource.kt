package com.example.movie.data.repository.artist.datasource

import com.example.movie.data.model.artist.Artist
import com.example.movie.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtist():Response<ArtistList>
}