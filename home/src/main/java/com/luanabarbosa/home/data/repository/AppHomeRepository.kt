package com.luanabarbosa.home.data.repository

import com.luanabarbosa.home.data.mapper.HomeMapper
import com.luanabarbosa.home.data.model.CoreModel
import com.luanabarbosa.home.data.service.HomeApi
import com.luanabarbosa.network.response.ApiResponse

class AppHomeRepository(
    private val service: HomeApi,
    private val mapper: HomeMapper
) : HomeRepository {

    override suspend fun getHomeCards(): ApiResponse<List<CoreModel>> {
        return try {
            val cards = service.getCards()
            ApiResponse.Success(
                cards.core.map {
                    mapper.toCardModel(it)
                }
            )
        } catch (e: Exception) {
            ApiResponse.Error(exception = e)
        }
    }
}

interface HomeRepository {
    suspend fun getHomeCards(): ApiResponse<List<CoreModel>>
}
