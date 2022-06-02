package com.luanabarbosa.details.domain.mapper

import com.luanabarbosa.details.data.model.CoreDetailsModel
import com.luanabarbosa.details.data.response.CoreDetailsResponse
import org.mapstruct.Mapper

@Mapper
interface DetailsMapper {
    fun responseToModel(response: CoreDetailsResponse): CoreDetailsModel
}
