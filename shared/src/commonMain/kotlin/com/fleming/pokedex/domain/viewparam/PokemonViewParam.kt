package com.fleming.pokedex.domain.viewparam

import com.fleming.pokedex.data.model.PokemonResponse

data class PokemonViewParam(
    val name: String,
    val weight: Int,
    val height: Int,
    val sprite: String
) {
    constructor(response: PokemonResponse) : this(
        name = response.name.orEmpty(),
        weight = response.weight,
        height = response.height,
        sprite = response.sprites?.other?.officialArtwork?.front_default.orEmpty()
    )
}
