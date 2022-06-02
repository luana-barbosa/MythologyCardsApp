package com.luanabarbosa.details.data.service

import com.luanabarbosa.details.data.response.CoreDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("cards/{cardId}")
    suspend fun getCardsDetails(@Path("cardId")cardId: String): List<CoreDetailsResponse>
}
