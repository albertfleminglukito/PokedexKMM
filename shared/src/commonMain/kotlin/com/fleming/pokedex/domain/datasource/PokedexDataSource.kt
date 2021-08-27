package com.fleming.pokedex.domain.datasource

import com.fleming.pokedex.base.Result
import com.fleming.pokedex.data.model.PokemonListResponse
import com.fleming.pokedex.data.model.PokemonResponse

interface PokedexDataSource {

    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListResponse>

    suspend fun getPokemonDetail(id: String): Result<PokemonResponse>

}