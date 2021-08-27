package com.fleming.pokedex.data.model

import kotlinx.serialization.Serializable

@Serializable
class PokemonListResponse(
    val count: Int,
    val next: String? = "",
    val previous: String? = "",
    val results: List<Pokemon>
) {

    @Serializable
    class Pokemon(
        val name: String,
        val url: String
    )

}
