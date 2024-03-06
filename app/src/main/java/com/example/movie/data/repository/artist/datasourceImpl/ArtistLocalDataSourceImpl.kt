package com.example.movie.data.repository.artist.datasourceImpl

import com.example.movie.data.db.ArtistDao
import com.example.movie.data.model.artist.Artist
import com.example.movie.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistFromDb(): List<Artist> {
       return artistDao.getArtist()
    }

    override suspend fun saveArtistFromDb(artist: List<Artist>) {
       CoroutineScope(Dispatchers.IO).launch {
           artistDao.saveArtist(artist)
       }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           artistDao.deleteAllArtist()
       }
    }
}