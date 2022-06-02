package com.luanabarbosa.details.domain.usecase

import com.luanabarbosa.details.data.model.CoreDetailsModel
import com.luanabarbosa.details.data.repository.DetailsRepository
import com.luanabarbosa.network.response.ApiResponse

interface GetCardInfoUseCase {
    suspend operator fun invoke(cardId : String): ApiResponse<CoreDetailsModel>
}

class GetCardInfo(private val repository: DetailsRepository) : GetCardInfoUseCase {
    override suspend fun invoke(cardId : String): ApiResponse<CoreDetailsModel> =
        repository.getCardInfo(cardId)
}
