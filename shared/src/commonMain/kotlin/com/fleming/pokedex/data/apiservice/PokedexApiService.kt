package com.fleming.pokedex.data.apiservice

import com.fleming.pokedex.data.model.PokemonListResponse
import com.fleming.pokedex.data.model.PokemonResponse
import com.fleming.pokedex.base.Result

interface PokedexApiService {

    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListResponse>

    suspend fun getPokemonDetail(id: String): Result<PokemonResponse>

}
