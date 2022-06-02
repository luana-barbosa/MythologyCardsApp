package com.luanabarbosa.home.data.model

data class HomeCardsModel(
    val core: List<CoreModel>
)

data class CoreModel(
    val cardId: String = "",
    val name: String = "",
    val cardSet: String = "",
    val flavor: String = "",
    val text: String = "",
    val type: String = "",
    val faction: String = "",
    val rarity: String = "",
    val attack: String = "",
    val cost: String = "",
    val health: String = "",
    val img: String = ""
)
