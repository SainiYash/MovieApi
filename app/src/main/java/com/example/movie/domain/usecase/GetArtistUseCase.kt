package com.example.movie.domain.usecase

import com.example.movie.data.model.artist.Artist
import com.example.movie.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.getArtist()
}