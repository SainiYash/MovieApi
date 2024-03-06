package com.example.movie.data.repository.artist.datasource

import com.example.movie.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistFromCache():List<Artist>

    suspend fun saveArtistFromCache(artist: List<Artist>)

}