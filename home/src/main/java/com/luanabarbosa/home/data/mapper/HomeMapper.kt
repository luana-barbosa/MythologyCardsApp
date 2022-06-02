package com.luanabarbosa.home.data.mapper

import com.luanabarbosa.home.data.model.CoreModel
import com.luanabarbosa.home.data.response.CoreResponse

interface HomeMapper {
    fun toCardModel(
        response: CoreResponse,
    ): CoreModel
}