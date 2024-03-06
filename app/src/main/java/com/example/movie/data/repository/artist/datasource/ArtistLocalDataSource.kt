package com.example.movie.data.repository.artist.datasource

import com.example.movie.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistFromDb():List<Artist>

    suspend fun saveArtistFromDb(artist: List<Artist>)

    suspend fun clearAll()
}