package com.luanabarbosa.details.data.repository

import com.luanabarbosa.details.data.model.CoreDetailsModel
import com.luanabarbosa.details.data.service.DetailsApi
import com.luanabarbosa.details.domain.mapper.DetailsMapper
import com.luanabarbosa.network.response.ApiResponse

class AppDetailsRepository(
    private val detailsApi: DetailsApi,
    private val mapper: DetailsMapper
) : DetailsRepository {
    override suspend fun getCardInfo(cardId: String): ApiResponse<CoreDetailsModel> {
        return try {
            val response = detailsApi.getCardsDetails(cardId = cardId)
            ApiResponse.Success(
                response.map {
                    mapper.responseToModel(it)
                }.first()
            )
        } catch (e: Exception) {
            ApiResponse.Error(exception = e)
        }
    }
}

interface DetailsRepository {
    suspend fun getCardInfo(cardId: String): ApiResponse<CoreDetailsModel>
}
