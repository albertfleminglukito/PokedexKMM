package com.fleming.pokedex.data.local.dao

import com.fleming.pokedex.data.local.PokemonList
import com.fleming.pokedex.data.model.PokemonListResponse

interface PokedexListDao {

    suspend fun getPokemonList(): List<PokemonList>

    suspend fun insertPokemonList(list: List<PokemonListResponse.Pokemon>)

    suspend fun deleteAllPokemonList()

}