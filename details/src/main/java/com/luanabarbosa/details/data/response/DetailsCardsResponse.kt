package com.luanabarbosa.details.data.response

import java.io.Serializable

data class CoreDetailsResponse(
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
) : Serializable
