package com.example.movie.data.repository.artist.datasourceImpl

import android.util.Log
import com.example.movie.data.model.artist.Artist
import com.example.movie.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.movie.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.movie.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.movie.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
):ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtist(): List<Artist>? {
        TODO("Not yet implemented")
    }

    suspend fun getArtistfromApi():List<Artist>
    {
        lateinit var artistList:List<Artist>

        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body!=null)
            {
                artistList = body.artists
            }
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        return artistList
    }


    suspend fun getArtistFromDb():List<Artist>
    {
        lateinit var artistList:List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistFromDb()
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        if(artistList.size>0)
        {
            return artistList
        }else{
            artistList = getArtistfromApi()
            artistLocalDataSource.saveArtistFromDb(artistList)
        }

        return artistList
    }

    suspend fun getArtistFromCache():List<Artist>
    {
        lateinit var artistList:List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (exception: Exception){
            Log.i("My tag",exception.message.toString())
        }

        if(artistList.size>0)
        {
            return artistList
        }else{
            artistList = getArtistFromDb()
            artistCacheDataSource.saveArtistFromCache(artistList)
        }

        return artistList
    }




}