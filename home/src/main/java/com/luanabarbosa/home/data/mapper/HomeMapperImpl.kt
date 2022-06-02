package com.luanabarbosa.home.data.mapper

import com.luanabarbosa.home.data.model.CoreModel
import com.luanabarbosa.home.data.response.CoreResponse

class HomeMapperImpl : HomeMapper {
    override fun toCardModel(response: CoreResponse) =
        CoreModel(
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