package com.example.movie.domain.usecase

import com.example.movie.data.model.tvShow.TvShow
import com.example.movie.domain.repository.TvRepository

class GetTvShowUseCase(private val tvRepository: TvRepository) {

    suspend fun execute():List<TvShow>? = tvRepository.viewTvShow()
}