package com.example.movie.data.repository.artist.datasourceImpl

import com.example.movie.data.model.artist.Artist
import com.example.movie.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList

    }

    override suspend fun saveArtistFromCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}