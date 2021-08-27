package com.fleming.pokedex.domain.viewparam

import com.fleming.pokedex.data.model.PokemonListResponse
import kotlinx.serialization.Serializable

data class PokemonListViewParam(
    val count: Int,
    val results: List<Pokemon>
) {
    constructor(response: PokemonListResponse) : this(
        count = response.count,
        results = response.results.map { Pokemon(it) }
    )

    data class Pokemon(
        val name: String,
        val url: String
    ) {
        constructor(response: PokemonListResponse.Pokemon) : this(
            name = response.name,
            url = response.url
        )
    }

}
