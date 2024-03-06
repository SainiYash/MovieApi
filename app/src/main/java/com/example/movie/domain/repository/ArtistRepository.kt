package com.example.movie.domain.repository

import com.example.movie.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}