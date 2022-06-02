package com.luanabarbosa.details.domain.mapper

import com.luanabarbosa.details.data.model.CoreDetailsModel
import com.luanabarbosa.details.data.response.CoreDetailsResponse

class DetailsMapperImpl : DetailsMapper {
    override fun responseToModel(response: CoreDetailsResponse) =
        CoreDetailsModel(
            cardId = response.cardId,
            name = response.name,
            cardSet = response.cardSet,
            flavor = response.flavor,
            text = response.text,
            type = response.type,
            faction = response.faction,
            rarity = response.rarity,
            attack = response.attack,
            cost = response.cost,
            health = response.health,
            img = response.img
        )
}
