package com.fleming.pokedex.domain.interactor

import com.fleming.pokedex.base.Result
import com.fleming.pokedex.domain.viewparam.PokemonListViewParam

interface PokedexInteractor {

    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListViewParam>

}
