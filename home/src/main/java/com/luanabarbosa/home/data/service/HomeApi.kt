package com.luanabarbosa.home.data.service

import com.luanabarbosa.home.data.response.HomeCardsResponse
import retrofit2.http.GET

interface HomeApi {
    @GET("cards")
    suspend fun getCards(): HomeCardsResponse
}
