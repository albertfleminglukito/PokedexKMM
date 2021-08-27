package com.fleming.pokedex.domain.interactor

import com.fleming.pokedex.base.Result
import com.fleming.pokedex.domain.viewparam.PokemonViewParam

interface PokemonInteractor {

    suspend fun getPokemonDetail(id: String): Result<PokemonViewParam>

}
