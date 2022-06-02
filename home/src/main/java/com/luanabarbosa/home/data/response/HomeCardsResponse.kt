package com.luanabarbosa.home.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HomeCardsResponse(
    @SerializedName("Core")
    val core: List<CoreResponse>
)

data class CoreResponse(
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
): Serializable
