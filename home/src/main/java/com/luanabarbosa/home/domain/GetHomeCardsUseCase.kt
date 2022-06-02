package com.luanabarbosa.home.domain

import com.luanabarbosa.home.data.model.CoreModel
import com.luanabarbosa.home.data.repository.HomeRepository
import com.luanabarbosa.network.response.ApiResponse

interface GetHomeCardsUseCase {
    suspend operator fun invoke(): ApiResponse<List<CoreModel>>
}

class GetHomeCards(private val repository: HomeRepository) : GetHomeCardsUseCase {
    override suspend fun invoke(): ApiResponse<List<CoreModel>> =
        repository.getHomeCards()
}
